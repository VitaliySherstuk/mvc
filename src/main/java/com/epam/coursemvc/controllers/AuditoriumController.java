package com.epam.coursemvc.controllers;

import beans.models.Auditorium;
import beans.services.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auditoriums")
public class AuditoriumController {

    @Autowired
    private AuditoriumService auditoriumService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAuditoriumPage(){
        return "auditoriums";
    }


    @RequestMapping(value="/getAllAuditorium", method=RequestMethod.GET)
    public String getAllAuditoruimsPage(Model model) {
        model.addAttribute("auditoriums", auditoriumService.getAuditoriums());
        return "allAuditoriums";
    }

    @RequestMapping(value="/getAuditorium", method = RequestMethod.POST)
    public String getAditoriumByName(@RequestParam(name = "nameAuditorium") String nameAuditorium, Model model) {

        Auditorium auditorium = auditoriumService.getByName(nameAuditorium);
        model.addAttribute("auditorium", auditorium);

        return "certainAuditorium";
    }


}
