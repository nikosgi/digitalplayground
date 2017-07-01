package com.dp.digip.controllers;



import com.dp.digip.models.DAO.EventDAO;
import com.dp.digip.models.DAO.UserDAO;
import com.dp.digip.models.User;
import com.dp.digip.components.AuthenticationFacade;
import com.dp.digip.models.DTO.UserObject;
import com.dp.digip.models.DTO.ParentObject;
import com.dp.digip.components.interfaces.ServerLocationBo;
import com.dp.digip.models.DTO.ServerLocation;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



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

@Controller
public class MainController {


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

    @RequestMapping("/map")
    public ModelAndView map(Model model){//,HttpServletRequest request) {
        model.addAttribute("events",eventDao.findAll());
        model.addAttribute("imgUrl", "http://localhost:8080/event/image/");

	//out.println("The ip is = ");
	//out.println(request.getHeader("X-FORWARDED-FOR"));	
	//out.println(request.getRemoteAddr());
	String ip="4.2.2.2";
	ServerLocation location = serverLocationBo.getLocation(ip);

	if ( location == null)
		out.println("bad");

	
	String result = location.toString();
	out.println(result);


	return new ModelAndView("map","clientLocation",location);
        //return "map";
    }
    @RequestMapping("/search")
    public String s(Model model) {
        return "search";
    }

    @RequestMapping



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
    	public String registration(@ModelAttribute ParentObject parent,@RequestParam("username") String username,@RequestParam("email") String email,
		@RequestParam("password") String password,@RequestParam("dd") String birthDay,@RequestParam("mm")String birthMonth,@RequestParam("yyyy")String birthYear, Model model) {

		String role = "PARENT";
		String birthDateString = birthMonth+"/"+birthDay+"/"+birthYear;

		DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
		Date birthDate=null;
		try {
		    birthDate = df.parse(birthDateString);
		} catch (ParseException e) {
    			e.printStackTrace();
		}

		parent.setBirthDate(birthDate);
		parent.setMoney(0);
		
		UserObject newUser = new UserObject(email,username,password,role); 

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
