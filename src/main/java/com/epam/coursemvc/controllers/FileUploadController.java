package com.epam.coursemvc.controllers;

import beans.models.Event;
import beans.models.User;
import beans.services.EventService;
import beans.services.UserService;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;


@Controller
@RequestMapping("/load")
public class FileUploadController {

    private final static Logger LOG = Logger.getLogger(FileUploadController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;


    @RequestMapping(method=RequestMethod.GET)
    public String getLoadPage(){
        return  "loadBatch";
    }

    @RequestMapping(value ="/fileUsers", method= RequestMethod.POST)
    public String loadUsers(@RequestParam("file") MultipartFile file, Model model){

        Gson gson = new Gson();
        String jsonUsers = null;
        try {
            jsonUsers = new String(file.getBytes());
            LOG.info(jsonUsers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        User[] users = gson.fromJson(jsonUsers, User[].class);
        Arrays.stream(users).forEach(r -> userService.register(r));
        model.addAttribute("success_u", true);
        return "loadBatch";
    }

    @RequestMapping(value ="/fileEvents", method= RequestMethod.POST)
    public String loadEvents(@RequestParam("file") MultipartFile file, Model model){

        Gson gson = new Gson();
        String jsonEvents = null;
        try {
            jsonEvents = new String(file.getBytes());
            LOG.info(jsonEvents);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Event[] events = gson.fromJson(jsonEvents, Event[].class);
        Arrays.stream(events).forEach(r -> eventService.create(r));
        model.addAttribute("success_e", true);
        return "loadBatch";
    }

}
