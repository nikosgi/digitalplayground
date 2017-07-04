package com.dp.digip.controllers;

/**
 * Created by Nikos on 21/5/2017.
 */
import com.dp.digip.models.Event;
import com.dp.digip.models.DAO.TransactionDAO;
import com.dp.digip.models.DAO.EventDAO;
import com.dp.digip.models.DAO.UserDAO;
import com.dp.digip.models.DAO.CommentDAO;
import com.dp.digip.models.User;
import com.dp.digip.models.Comment;
import com.dp.digip.models.Parent;
import com.dp.digip.models.MessageDTO;
import com.dp.digip.models.Greeting;
import com.dp.digip.models.Transaction;
import com.dp.digip.components.AuthenticationFacade;
import org.springframework.security.core.Authentication;
import com.dp.digip.service.GeneralService;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



@Controller
@RequestMapping("event")
public class EventController {

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Autowired 
    private UserDAO userDao;

    @Autowired
    private EventDAO eventDao;

    @Autowired
    private TransactionDAO transactionDao;

    @Autowired
    private CommentDAO commentDao;

    @Autowired
    private GeneralService generalService;

    @RequestMapping(value ="")
    public String index(Model model){
        model.addAttribute("events",eventDao.findAll());
        model.addAttribute("title","All Esers");
        model.addAttribute("imgUrl", "http://localhost:8080/event/image/");
        return "events/index";
    }

    @RequestMapping(value ="add", method = RequestMethod.GET)
    public String displayAddUser(Model model) {
        model.addAttribute("title","add user");
        model.addAttribute(new Event());
        return "events/add";
    }



    @RequestMapping(value ="add", method = RequestMethod.POST)
    public String processAddUser(@RequestParam("name") String name, @RequestParam("file") MultipartFile file,    @RequestParam("desc") String description, RedirectAttributes redirectAttributes) throws IOException {

        Authentication auth = authenticationFacade.getAuthentication();
	String username = auth.getName();

	User eventOwner = userDao.findByUsername(username);

        byte[] image = file.getBytes();
        System.out.println(file.getSize());
        Event event = new Event(name,image,description,eventOwner);
        eventDao.save(event);
        return "redirect:";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String displayEvent(@PathVariable("id") Long event_id, Model model){
        Event event = eventDao.findOne(event_id);
	
	//HashSet<Comment> comments = new HashSet<Comment>( event.getComments() );
	List<Comment> comments = new ArrayList<Comment>(event.getComments() );
    model.addAttribute("event", event);
    model.addAttribute("comments", comments );
    model.addAttribute("event_lat", 37.4429);
    model.addAttribute("event_lng", -122.1419);



	//model.addAttribute("event",eventDao.findOne(event_id));
	
        return "/event";

    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public MessageDTO sendComment(Greeting message) throws Exception {
        Thread.sleep(500);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();
        System.out.println("I AM HERE");
        System.out.println(message.getName() + " " + message.getEid());
        System.out.println(message.getUsern());
	    User commenter = userDao.findByUsername(message.getUsern());
	    Event event = eventDao.findOne(message.getEid());	

	   
	   Comment comment = new Comment(message.getName(),4,currentDate,commenter,event);
	   commentDao.save(comment);

	return new MessageDTO(message.getName(),commenter.getUsername()); 
    }
 

    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public String ckeckoutEvent(@PathVariable("id") Long event_id , @RequestParam("qty") int tickets, Model model){
	//Long event_id = new Long(3);
	//int tickets = 2;

	Event event = eventDao.findOne(event_id);

	int tickets_initial = event.getTicketsInitial();
	int tickets_remaining = event.getTicketsRemaining();
	int cost = event.getCost();
	int totalCost = tickets * cost;
	
	if ( tickets_remaining - tickets < 0 ){
		System.out.println("\n dont have so much tickets");	
         List<Comment> comments = new ArrayList<Comment>(event.getComments());
        model.addAttribute("comments", comments );
        model.addAttribute("event",event);  
        model.addAttribute("error_string", "Sorry, there aren't any tickets left for this event");
        return "/event";
	}

        Authentication auth = authenticationFacade.getAuthentication();
        String username = auth.getName();

        Parent parent = generalService.parentFromUsername(username);
        int user_money = parent.getMoney();

	if ( user_money < totalCost ){
		System.out.println("\n\nsorry not enough money");
        List<Comment> comments = new ArrayList<Comment>(event.getComments());
        model.addAttribute("comments", comments );
		model.addAttribute("error_string", "Sorry, you don't have enough money for this ticket(s)!");
        model.addAttribute("event",event);  
        return "/event";
	} 	

	event.setTicketsRemaining( tickets_remaining - tickets);
	eventDao.save(event);

        User userBuyer = userDao.findByUsername(username);	
		
	parent.setMoney( user_money-totalCost);	
	userBuyer.setParent(parent);
	userDao.save(userBuyer);

	Transaction trans = new Transaction(tickets, userBuyer, event);	
	
	transactionDao.save(trans);		

	return "/event";		

    }

    
    @RequestMapping(value = "/more",method = RequestMethod.GET)
    public String more(Model model){
	Long trans_id = new Long(1);

	Transaction trans = transactionDao.findOne(trans_id);
	
	User user = trans.getUser();	

	System.out.println(user.getUsername());

	System.out.println("\n\n\n\n\nHEY");
	HashSet<Transaction> trans_set = new HashSet<Transaction>(user.getTransactions());
	if ( trans_set == null)
		System.out.println("\n\n\n\n\n bye bull" );
	else{
		System.out.println(trans_set.size());
	}
	if ( trans_set.contains(trans) )
		System.out.println("hey i am here");	

	return "/index";
    }


    @RequestMapping(value = "/image/{image_id}",method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public ResponseEntity<byte[]> getImage(@PathVariable("image_id") Long imageId) throws IOException {

        byte[] image= eventDao.findOne(imageId).getImage();
        System.out.println(Arrays.toString(image));
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]> (image, headers, HttpStatus.CREATED);
    }






} // class UserController
