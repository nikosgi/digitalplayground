package com.dp.digip.controllers;



import com.dp.digip.models.DAO.EventDAO;
import com.dp.digip.models.DAO.UserDAO;
import com.dp.digip.models.User;
import com.dp.digip.models.Event;
import com.dp.digip.models.Transaction;
import com.dp.digip.models.Parent;
import com.dp.digip.components.AuthenticationFacade;
import com.dp.digip.models.DTO.UserObject;
import com.dp.digip.models.DTO.ParentObject;
import com.dp.digip.components.interfaces.ServerLocationBo;
import com.dp.digip.models.DTO.ServerLocation;
import com.dp.digip.service.GeneralService;
import com.dp.digip.CustomSearch;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Arrays;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import java.io.File;
import java.io.FileInputStream;
import org.springframework.web.servlet.ModelAndView; 
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import com.dp.digip.service.SecurityService;
import com.dp.digip.service.UserServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.validation.BindingResult;
import static java.lang.System.out;

import java.lang.Object;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat; 

import java.text.ParseException;
import java.lang.Exception;
import java.util.concurrent.Callable;
import java.lang.Thread;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    private CustomSearch search;

    @Autowired 
    private ServerLocationBo serverLocationBo;

    @Autowired
    private AuthenticationFacade authenticationFacade; 

    @Autowired
    private EventDAO eventDao;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private GeneralService generalService;

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("events",eventDao.findAll());
        model.addAttribute("imgUrl", "http://localhost:8080/event/image/");

	out.println("in index ");
	
	Authentication auth = authenticationFacade.getAuthentication();
	Object princ = auth.getPrincipal();
	
	out.println("\n\n");	

	if ( princ.toString() != null )	{
		out.println(auth.getName()+"\n");
		out.println(auth.toString()+"\n" ) ;
		out.println(princ.toString()+"\n" );
	}	
	else
		out.println("bye");


	//Object cred = auth.getCredentials();
	//Object det = auth.getDetails();

	//out.println(cred.toString() ) ;
  	//out.println(auth.getDetails().toString() );        
	

        return "index";
    }

/*
    @RequestMapping("/")
    public Callable<String> welcome(Model model){
	
	return new Callable<String>(){

		public String call() throws Exception{

			Thread.sleep(10000);
			out.println("outputing after sleep");
			return "index";
		}
		
	};


    }   

*/

    @RequestMapping(value = "/myprofile", method = RequestMethod.GET)
    public String myprofile(Model model){
	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date currentDate = new Date();	
	out.println(dateFormat.format(currentDate));

	ArrayList<Event> pastEvents = new ArrayList<Event>();
	ArrayList<Event> comingEvents = new ArrayList<Event>();

	model.addAttribute("events",eventDao.findAll());
    model.addAttribute("imgUrl", "http://localhost:8080/event/image/");
    model.addAttribute("profileUrl", "http://localhost:8080/myprofile/image/");
    Authentication auth = authenticationFacade.getAuthentication();
    String username = auth.getName();
	User user = userDao.findByUsername(username);
	Parent parent = generalService.parentFromUsername(username);
	
	model.addAttribute("user",user );
	model.addAttribute("parent",parent);

	model.addAttribute("birthDate", dateFormat.format(parent.getBirthDate()));

	Set<Transaction> transactions = user.getTransactions() ;

	if ( transactions.size() >= 0 ){
		Event event = null;
		Date eventDate = null;
		for (Transaction trans : transactions){
			event =  trans.getEvent();
			eventDate = event.getDate();	
			out.println("lalala\n\n\n\n"+eventDate);
		
			if ( currentDate.after(eventDate) )
				pastEvents.add(event);
			else
				comingEvents.add(event); 
		}
	}

        model.addAttribute("pastEvents",pastEvents);
        model.addAttribute("comingEvents",comingEvents);
		
	return "myprofile";
    }


    @RequestMapping(value = "/profile/{username}", method = RequestMethod.GET)
    public String profile(Model model,@PathVariable("username") String username){//,HttpServletRequest request) {
        model.addAttribute("events",eventDao.findAll());
        model.addAttribute("imgUrl", "http://localhost:8080/event/image/");
        model.addAttribute("profileUrl", "http://localhost:8080/myprofile/image/");
	//lucene search for that user.
	/*	
	List<User> resultSet = null;
	resultSet = search.userSearch(username);		 		
	
	User user = resultSet.get(0);
	out.println(user.getUsername());
	out.println("here");	
	*/


////////location
	String ip="4.2.2.2";
	ServerLocation location = serverLocationBo.getLocation(ip);

	if ( location == null)
		out.println("bad");

	
	String result = location.toString();
	out.println(result);

	model.addAttribute("clientLocation",location);


//////////parent
	Parent parent = generalService.parentFromUsername(username);

	out.println(parent.getName());
	
	model.addAttribute("parent",parent);	

	


        return "profile";
    }

    @RequestMapping(value = "/myprofile/image/{image_id}",method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public ResponseEntity<byte[]> getImage(@PathVariable("image_id") Long imageId) throws IOException {

        byte[] image= userDao.findOne(imageId).getImage();
        System.out.println(Arrays.toString(image));
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]> (image, headers, HttpStatus.CREATED);
    }


    @Controller
    public class SignupController {
		@Autowired
		private UserServiceImpl userService;

		@Autowired
		private SecurityService securityService;

    	@RequestMapping(value = "/signup", method = RequestMethod.GET)
    	public String registration(Model model) {
        	model.addAttribute("userForm", new User());

		out.println("here arrived");

        	return "signup";
    	}

    	@RequestMapping(value = "/signup", method = RequestMethod.POST)
    	public String registration(@ModelAttribute ParentObject parent, @RequestParam("username") String username, @RequestParam("email") String email,
		@RequestParam("password") String password,@RequestParam("dd") String birthDay,@RequestParam("mm")String birthMonth,@RequestParam("yyyy")String birthYear,
		@RequestParam("file") MultipartFile file, Model model) throws IOException {

		String role = "PARENT";
		String birthDateString = birthMonth+"/"+birthDay+"/"+birthYear;
		byte[] image = file.getBytes();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
		Date birthDate=null;
		try {
		    birthDate = df.parse(birthDateString);
		} catch (ParseException e) {
    			e.printStackTrace();
		}

		parent.setBirthDate(birthDate);
		parent.setMoney(0);
		
		UserObject newUser = new UserObject(email,username,password,role,image); 

	        userService.saveUser(newUser,parent);	

       		securityService.autologin(username, password);
        
		return "signup";
    	}

    }


    @Controller
    public class LogController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String listGifs(){
		out.println("inside login");
		return "login";
	}


	//login implemented from spring WebSecurity
	    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
    	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
		  new SecurityContextLogoutHandler().logout(request, response, auth);
    	    }else{
		out.println("not logged in");
		return "redirect:/errorError";
	    }
    	    return "redirect:/login";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
        }

    }






}
