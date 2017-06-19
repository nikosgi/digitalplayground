package com.dp.digip.controllers;

/**
 * Created by Nikos on 21/5/2017.
 */

import com.dp.digip.models.DAO.EventDAO;
import com.dp.digip.models.DAO.UserDAO;
import com.dp.digip.models.User;
import com.dp.digip.components.AuthenticationFacade;
import com.dp.digip.models.DTO.UserObject;
import com.dp.digip.models.DTO.ParentObject;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


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


import static java.lang.System.out;

import org.springframework.validation.BindingResult;
import static java.lang.System.out;

import java.lang.Object;

@Controller
public class MainController {

    @Autowired
    private AuthenticationFacade authenticationFacade; 

    @Autowired
    private EventDAO eventDao;

    @Autowired
    private UserDAO userDao;

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

    @RequestMapping("/map")
    public String map(Model model) {
        model.addAttribute("events",eventDao.findAll());
        model.addAttribute("imgUrl", "http://localhost:8080/event/image/");
        return "map";
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
    	public String registration(@ModelAttribute ParentObject parent,@RequestParam("username") String username,@RequestParam("email") String email,
		@RequestParam("password") String password,@RequestParam("dd") String birthDay,@RequestParam("mm")String birthMonth,@RequestParam("yyyy")String birthYear, Model model) {

		String role = "PARENT";
	
		out.println("username = "+username);
		out.println("password = "+password);
		out.println("email = "+email);
		out.println("parent name= "+parent.getName());
		out.println("parent surname= "+parent.getSurname());
		out.println("parent cellphone= "+parent.getCellphone());
		out.println("parent phone= "+parent.getPhone());		
		out.println("parent region= "+parent.getRegion());
		out.println("parent municipality"+ parent.getMunicipality());		
		out.println("parent country "+ parent.getCountry());

		out.println("birthday "+ birthDay);
		out.println("birthMonth "+ birthMonth);
		out.println("birthYear "+ birthYear);


	
	
        	//userStoreService.save(userForm);

        //	securityService.autologin(userForm.getUsername(), userForm.getPassword());
		out.println("here3");
        
		return "redirect:/index";
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
