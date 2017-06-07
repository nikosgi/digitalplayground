package com.dp.digip.controllers;

/**
 * Created by Nikos on 21/5/2017.
 */

import com.dp.digip.service.SecurityService;
import com.dp.digip.service.UserService;
import com.dp.digip.validator.UserValidator;

import com.dp.digip.models.DAO.EventDAO;
import com.dp.digip.models.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.dp.digip.models.User;

import static java.lang.System.out;

import org.springframework.validation.BindingResult;
import static java.lang.System.out;

import java.util.Map;

@Controller
public class MainController {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";


    @Autowired
    private EventDAO eventDao;

    @Autowired
    private UserDAO userDao;

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("events",eventDao.findAll());
        model.addAttribute("imgUrl", "http://localhost:8080/event/image/");
        return "index";
    }

    @Controller
    public class SignupController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

    	@RequestMapping(value = "/registration", method = RequestMethod.GET)
    	public String registration(Model model) {
        	model.addAttribute("userForm", new User());

        	return "registration";
    	}

    	@RequestMapping(value = "/registration", method = RequestMethod.POST)
    	public String registration(@ModelAttribute("userForm") User userForm, Model model) {

		out.println("here1");
        	userService.save(userForm);
		out.println("here2");
        	securityService.autologin(userForm.getUsername(), userForm.getPassword_confirmation());
		out.println("here3");
        	return "redirect:/index";
    	}
	@RequestMapping(value = "/login")
        public String listGifs(){

	    out.println("inside login");	    

            return "login";
        }
	
	@RequestMapping(value = "login" ,method = RequestMethod.POST)
        public String loggedIn(@RequestParam String username,@RequestParam String password){
		out.println("logged in pressed");
		out.println(username);
		out.println(password);

		User the_user = userDao.findByUsername(username);
		out.println(the_user.getEmail() );

		

		return "index";		

	}	


    }

    


    @Controller
    public class UnderConstructionController {
        @RequestMapping(value = "/under_construction")
        public String listGifs(){

            return "under_construction";
        }
    }
}
