package com.epam.coursemvc.controllers;

import beans.models.User;
import beans.services.UserService;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final static Logger LOG = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(method= RequestMethod.GET)
    public String myMeth(){

        return "registration";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createUser(@RequestParam(value="username") String username,
                             @RequestParam(value="email") String email,
                             @RequestParam(value="date") String date,
                             @RequestParam(value="role") String role,
                             @RequestParam(value="password") String password,
                             Model model){

        LOG.info("username: " + username);
        LOG.info("email: " + email);
        LOG.info("date: " + date);
        LOG.info("password: " + password);
        LOG.info("role: " + role);
        User user = new User(email, username, LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE), password, role);
        model.addAttribute("result", "user was created");
        userService.register(user);

        return "login";
    }
}
