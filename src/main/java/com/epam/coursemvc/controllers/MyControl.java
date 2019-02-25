package com.epam.coursemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class MyControl {

    @RequestMapping(method=RequestMethod.GET)
    public String myMeth(){

        return "users";
    }
}
