package com.epam.coursemvc.controllers;

import beans.models.Auditorium;
import beans.services.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/auditoriums")
public class AuditoriumController {

    @Autowired
    private AuditoriumService auditoriumService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAuditoriumPage(){
        return "auditoriums";
    }

    @RequestMapping(value="/getAuditorium", method = RequestMethod.POST)
    public String getAditoriumByName(@RequestParam(name = "nameAuditorium") String nameAuditorium, Model model) {

        Auditorium auditorium = auditoriumService.getByName(nameAuditorium);
        if(auditorium==null){
            model.addAttribute("notAuditorium", true);
            return "auditoriums";
        }
        model.addAttribute("auditorium", auditorium);
        return "certainAuditorium";
    }

    @RequestMapping(value="/getAllAuditorium", method=RequestMethod.GET)
    public String getAllAuditoruims(Model model) {

        List<Auditorium> auditoriumList = auditoriumService.getAuditoriums();
        if(auditoriumList.size()>0){
            model.addAttribute("auditoriums", auditoriumList);
            return "allAuditoriums";
        }
        model.addAttribute("notAuditoriums", true);
        return "auditorium";
    }


}
