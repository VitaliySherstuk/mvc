package com.epam.coursemvc.controllers;

import beans.models.Event;
import beans.models.Rate;
import beans.services.AuditoriumService;
import beans.services.EventService;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    private final static Logger LOG = Logger.getLogger(EventController.class);

    @Autowired
    AuditoriumService auditoriumService;

    @Autowired
    EventService eventService;

    @RequestMapping(method = RequestMethod.GET)
    public String getEventPage(){

        return "events";
    }

    @RequestMapping(value="/addEvent", method = RequestMethod.POST)
    public String addEvent(@RequestParam("eventName") String eventName,
                           @RequestParam("rate") String rate,
                           @RequestParam("basePrice") String basePrice,
                           @RequestParam("date") String date,
                           @RequestParam("time") String time,
                           @RequestParam("auditorium") String auditorium,
                           @RequestParam("ticketPrice") String ticketPrice,
                           Model model){
        LOG.info("eventName: " + eventName);
        LOG.info("rate: " + rate);
        LOG.info("basePrice: " + basePrice);
        LOG.info("date: " + date);
        LOG.info("time: " + time);
        LOG.info("auditorium: " + auditorium);
        LOG.info("audit from service: " + auditoriumService.getByName(auditorium));
        LOG.info("ticketPrice");

        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
        Event event = new Event(eventName, getEnumFromRequest(rate), Double.valueOf(basePrice),
                LocalDateTime.of(LocalDate.parse(date, formatterDate), LocalTime.parse(time, formatterTime)),
                auditoriumService.getByName(auditorium), BigDecimal.valueOf(Long.valueOf(ticketPrice)));
        eventService.create(event);
        model.addAttribute("message", true);
        Gson gson = new Gson();
        LOG.info(gson.toJson(event));
        return "events";
    }

    @RequestMapping(value="/allEvents", method = RequestMethod.GET)
    public String getAllEvents(Model model){

        List<Event> eventList = eventService.getAll();
        LOG.info("eventList size: " + eventList.size());
        if(eventList.size()>0){
            model.addAttribute("events", eventList);
            return "allEventsPage";
        }else{

            model.addAttribute("notEvents", true);
        }
        return "events";
    }

    @RequestMapping(value = "/getEvent", method = RequestMethod.POST)
    public String getEvent(@RequestParam(value="eventName") String eventName,
                           @RequestParam(value="auditorium") String auditorium,
                           @RequestParam(value="date") String date,
                           @RequestParam(value="time") String time, Model model){

        LOG.info("IN getEVNT mthd");
        LOG.info("date: " + date);
        LOG.info("time: " + time);
        LOG.info("auditorium" + auditorium);
        LOG.info("auditorium" + auditoriumService.getByName(auditorium));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime localDateTime =  LocalDateTime.of(LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE),
                LocalTime.parse(time, formatter));
        Event event = eventService.getEvent(eventName, auditoriumService.getByName(auditorium),
                localDateTime);
        LOG.info("event: " + event);
        LOG.info("localDateTime: " +localDateTime);
        if(event==null){
            model.addAttribute("notCertainEvent", true);
        }else{
            model.addAttribute("certainEvent", true);
            model.addAttribute("event", event);
        }
        return "certainEvents";
    }

    @RequestMapping(value="/removeEvent", method = RequestMethod.POST)
    public String removeEventByName(@RequestParam(value = "eventName") String eventname, Model model){

        List<Event> events = eventService.getByName(eventname);
        events.stream().forEach(r ->  eventService.remove(r));
        LOG.info("AMOUNT: " + events.size());
        if(events.size()>0){
            model.addAttribute("del_message", true);

        }
        else{
            model.addAttribute("n_del_message", true);

        }
        return  "events";
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
