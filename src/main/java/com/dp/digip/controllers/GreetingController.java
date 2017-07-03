package com.dp.digip.controllers;

import com.dp.digip.models.Greeting;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {


    @MessageMapping("/hellregero")
    @SendTo("/topic/greetingergergs")
    public Greeting greeting(String message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message + "!");
    }

}
