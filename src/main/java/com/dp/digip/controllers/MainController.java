package com.dp.digip.controllers;

/**
 * Created by Nikos on 21/5/2017.
 */
import com.dp.digip.models.DAO.EventDAO;
import com.dp.digip.models.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


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
        @RequestMapping(value = "/login")
        public String listGifs(){

            return "login";
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
