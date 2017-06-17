package com.dp.digip.controllers;

import com.dp.digip.models.User;
import com.dp.digip.models.DAO.UserDAO;
import com.dp.digip.models.Role;
import com.dp.digip.service.UserStoreService;
//import com.dp.digip.models.DAO.RoleDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.lang.System.out;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserStoreService userStoreService;

    
    @RequestMapping(value ="")
    public String index(Model model){
        model.addAttribute("users",userDao.findAll());
        model.addAttribute("title","All Users");
        return "user/index";
    }

    @RequestMapping(value ="add", method = RequestMethod.GET)
    public String displayAddUser(Model model) {
        model.addAttribute("title","add user");
        model.addAttribute(new User());
        return "user/add";
    }



    @RequestMapping(value ="add", method = RequestMethod.POST)
    public String processAddUser(@ModelAttribute User newUser, Errors errors, Model model){

        if(errors.hasErrors()){
            model.addAttribute("title","Add user");
            return "user/add";
        }
        	
	//User myUser = new User(newUser.getEmail(),newUser.getUsername(),newUser.getPassword(),new Role(newUser.getRole_temp()) );
	//userDao.save(myUser);	
	userStoreService.save(newUser);

        return "redirect:";
    }

    @RequestMapping(value ="remove", method = RequestMethod.GET)
    public String displayRemoveUser(Model model) {
        model.addAttribute("users",userDao.findAll());
        model.addAttribute("title","Remove User");
        return "user/remove";
    }

    @RequestMapping(value ="remove", method = RequestMethod.POST)
    public String processRemoveUser(@RequestParam int[] userIds){

        for (int userId: userIds){
            userDao.delete((long) userId);
        }
        return "redirect:";
    }


} // class UserController
