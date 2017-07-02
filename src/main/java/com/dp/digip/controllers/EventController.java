package com.dp.digip.controllers;

/**
 * Created by Nikos on 21/5/2017.
 */
import com.dp.digip.models.Event;
import com.dp.digip.models.DAO.TransactionDAO;
import com.dp.digip.models.DAO.EventDAO;
import com.dp.digip.models.DAO.UserDAO;
import com.dp.digip.models.User;
import com.dp.digip.models.Transaction;
import com.dp.digip.components.AuthenticationFacade;
import org.springframework.security.core.Authentication;


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

import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.Arrays;
import java.util.HashSet;

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
        model.addAttribute("event",eventDao.findOne(event_id));
        return "/event";

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public String ckeckoutEvent(@PathVariable("id") Long event_id , @RequestParam("qty") int tickets, Model model){
	//Long event_id = new Long(3);
	//int tickets = 2;

	Event event = eventDao.findOne(event_id);
	
	int tickets_initial = event.getTicketsInitial();
	int tickets_remaining = event.getTicketsRemaining();
			
	if ( tickets_remaining - tickets < 0 ){
		System.out.println("\n dont have so much tickets");	
		return "/errorError";
	}

	System.out.println("Event requested is \n\n\n");	

	event.setTicketsRemaining( tickets_remaining - tickets);
	eventDao.save(event);

        Authentication auth = authenticationFacade.getAuthentication();
        String username = auth.getName();

        User userBuyer = userDao.findByUsername(username);	

	Transaction trans = new Transaction(tickets, userBuyer, event);	
	
	transactionDao.save(trans);		

	return "/index";		

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
