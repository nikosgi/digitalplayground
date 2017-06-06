package com.dp.digip.controllers;

/**
 * Created by Nikos on 21/5/2017.
 */
import com.dp.digip.models.Event;
import com.dp.digip.models.DAO.EventDAO;


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

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.Arrays;

@Controller
@RequestMapping("event")
public class EventController {

    @Autowired
    private EventDAO eventDao;

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

/*

    @RequestMapping(value ="add", method = RequestMethod.POST)
    public String processAddUser(@RequestParam("name") String name, @RequestParam("file") MultipartFile file,    @RequestParam("desc") String description, RedirectAttributes redirectAttributes) throws IOException {

        byte[] image = file.getBytes();
        System.out.println(file.getSize());
        Event event = new Event(name,image,description);
        eventDao.save(event);
        return "redirect:";
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


*/

} // class UserController
