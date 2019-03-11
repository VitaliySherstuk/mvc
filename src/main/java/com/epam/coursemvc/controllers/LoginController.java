package com.epam.coursemvc.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    private final static Logger LOG = Logger.getLogger(LoginController.class);

    @Autowired
    @Qualifier("authenticationProvider")
    private DaoAuthenticationProvider daoAuthenticationProvider;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String getLogin(Model model){

        return "login";
    }


}
