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
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final static Logger LOG = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(method=RequestMethod.GET)
    public String myMeth(){

        return "users";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String createUser(@RequestParam(value="username") String username,
                                   @RequestParam(value="email") String email,
                                   @RequestParam(value="date") String date,
                                   @RequestParam(value="role") String role,
                                    Model model){

        LOG.info("username: " + username);
        LOG.info("email: " + email);
        LOG.info("date: " + date);
        LOG.info("role: " + role);
        User user = null;
        if(!role.equals("ROLE_USER")){
            user = new User(email, username, LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE), role);
        }
        else{
             user = new User(email, username, LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE));
        }
        model.addAttribute("result", "user was created");
        userService.register(user);
        Gson gson = new Gson();

        LOG.info(gson.toJson(user));
        return "users";
    }

    @RequestMapping(value="/userByName", method=RequestMethod.POST)
    public String getUserByName(@RequestParam(value="username") String username, Model model){

        LOG.info("in getUserByName meth".toUpperCase());
        LOG.info("username: " + username);

        List<User> userList = userService.getUsersByName(username);
        LOG.info("users from DB: " + userList.size());
        LOG.info("users from DB: " + userList);
        if(userList.size()>0){
            model.addAttribute("present", true);
            model.addAttribute("users", userList);
        }
        else{
            model.addAttribute("notUsersByName", true);
            return "users";
        }
        return "userByName";
    }

    @RequestMapping(value="/userByEmail", method=RequestMethod.POST)
    public String getUserByEmail(@RequestParam(value="email") String email, Model model){

        LOG.info("in getUserByEmail meth".toUpperCase());
        LOG.info("username: " + email);
        LOG.info("users from DB: " + userService.getUserByEmail(email));

        User user = userService.getUserByEmail(email);
        LOG.info(user);
        if(user==null){

            model.addAttribute("notexist", true);

            return "users";
        }
        else {

            model.addAttribute("present", true);
            model.addAttribute("user", user);
        }

        return "userByEmail";
    }
}
