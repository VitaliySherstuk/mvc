package com.epam.coursemvc.controllers;

import beans.models.Event;
import beans.models.Rate;
import beans.services.AuditoriumService;
import beans.services.EventService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/events")
public class EventController {

    private final static Logger LOG = Logger.getLogger(UserController.class);

    @Autowired
    AuditoriumService auditoriumService;

    @Autowired
    EventService eventService;

    @RequestMapping(method = RequestMethod.GET)
    public String getEventPage(){

        return "events";
    }

    @RequestMapping(value="addEvent", method = RequestMethod.POST)
    public String addEvent(@RequestParam("eventName") String eventName,
                           @RequestParam("rate") String rate,
                           @RequestParam("basePrice") String basePrice,
                           @RequestParam("date") String date,
                           @RequestParam("time") String time,
                           @RequestParam("auditorium") String auditorium, Model model){
        LOG.info("eventName: " + eventName);
        LOG.info("rate: " + rate);
        LOG.info("basePrice: " + basePrice);
        LOG.info("date: " + date);
        LOG.info("time: " + time);
        LOG.info("auditorium: " + auditorium);

        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy MM dd");
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
        Event event = new Event(eventName, getEnumFromRequest(rate), Double.valueOf(basePrice),
                LocalDateTime.of(LocalDate.parse(date, formatterDate), LocalTime.parse(time, formatterTime)),
                auditoriumService.getByName(auditorium));

        return "events";
    }

    private Rate getEnumFromRequest(String rate){

        switch(rate.toUpperCase()){

            case "HIGH":
                return Rate.HIGH;
            case "MID":
                return Rate.MID;
            case "LOW":
                return Rate.LOW;
        }
        return null;
    }
}
