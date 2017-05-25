package com.dp.digip.controllers;

/**
 * Created by Nikos on 21/5/2017.
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Map;

@Controller
public class MainController {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        return "index";
    }

    @Controller
    public class SignupController {
        @RequestMapping(value = "/signup_parent")
        public String listGifs(){

            return "signup_parent";
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