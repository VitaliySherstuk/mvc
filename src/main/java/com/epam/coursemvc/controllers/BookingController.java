package com.epam.coursemvc.controllers;

import beans.models.Event;
import beans.models.Ticket;
import beans.models.User;
import beans.services.AuditoriumService;
import beans.services.BookingService;
import beans.services.EventService;
import beans.services.UserService;
import com.itextpdf.text.DocumentException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import util.PdfDoc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/booking")
public class BookingController {

    private final static Logger LOG = Logger.getLogger(EventController.class);

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    @Autowired
    private AuditoriumService auditoriumServiceService;

    @ModelAttribute(value = "events")
    public List<Event> getEvents(){

        return eventService.getAll();
    }


    @RequestMapping(method= RequestMethod.GET)
    public String getBookingPage(Model model) {
        return "booking";
    }

    @RequestMapping(value = "/ticketPrice", method=RequestMethod.POST)
    public String getTicketPrice(@RequestParam("event") String event,
                                 @RequestParam("seats") String seats,
                                 @RequestParam("userEmail") String userEmail, Model model) {
        LOG.info(event);
        LOG.info(seats);
        LOG.info(userEmail);
        String[] eventFields = event.split("  ");
        String[] seatsArray = seats.split(" ");
        List<Integer> seatsList = Arrays.stream(seatsArray).map(r -> Integer.valueOf(r)).collect(Collectors.toList());
        if(userService.getUserByEmail(userEmail)==null){
            model.addAttribute("wrongUser", true);
            return "booking";
        }
        double ticketPrice = bookingService.getTicketPrice(eventFields[0], eventFields[1],
                LocalDateTime.parse(eventFields[2], DateTimeFormatter.ISO_LOCAL_DATE_TIME), seatsList, userService.getUserByEmail(userEmail));
        LOG.info("PRICE: " + ticketPrice);
        model.addAttribute("bookButton", true);
        model.addAttribute("ticketPrice", ticketPrice);
        model.addAttribute("event", event);
        model.addAttribute("seats", seats);
        model.addAttribute("userEmail", userEmail);
        return "preorder";
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String book(@RequestParam("event") String event,
                       @RequestParam("seats") String seats,
                       @RequestParam("userEmail") String userEmail,
                       @RequestParam("ticketPrice") String ticketPrice, Model model){


        LOG.info("BOOK");
        LOG.info("event: " + event);
        LOG.info("seats: " + seats);
        LOG.info("userEmail: " + userEmail);
        LOG.info("ticketPrice: " + ticketPrice);
        String[] eventFields = event.split("  ");
        String[] seatsArray = seats.split(" ");
        List<Integer> seatsList = Arrays.stream(seatsArray).map(r -> Integer.valueOf(r)).collect(Collectors.toList());
        Ticket ticket = bookingService.bookTicket(userService.getUserByEmail(userEmail),
                new Ticket(eventService.getEvent(eventFields[0], auditoriumServiceService.getByName(eventFields[1]),LocalDateTime.parse(eventFields[2], DateTimeFormatter.ISO_LOCAL_DATE_TIME)),
                        LocalDateTime.parse(eventFields[2], DateTimeFormatter.ISO_LOCAL_DATE_TIME), seatsList,
                        userService.getUserByEmail(userEmail), Double.parseDouble(ticketPrice.replace(",", "."))));

        model.addAttribute("message", true);
        return "preorder";
    }

    @RequestMapping(value = "/ticketForEvent", method=RequestMethod.POST)
    public String getTicketForEvent(@RequestParam("eventName") String eventName,
                                  @RequestParam("date") String date,
                                  @RequestParam("time") String time,
                                  @RequestParam("auditorium") String auditorium,
                                  Model model) {


        List<Ticket> tickets = bookingService.getTicketsForEvent(eventName, auditorium,
                        LocalDateTime.of(LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE), LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME)));
        if(tickets.size()==0){
            model.addAttribute("not_tickets", true);
            return "booking";
        }
        LOG.info(tickets);
        model.addAttribute("tickets", tickets);
        String id="";
        try {
            id = PdfDoc.createPdfDocument(tickets);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            LOG.info("ID in mthd getTicket"+id);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        model.addAttribute("id", id);
        return "tickets";
    }

    @RequestMapping(value ="/pdf",  method= RequestMethod.POST)
    public String load(@RequestParam("id") String id, HttpServletRequest req, HttpServletResponse resp){
        LOG.info("ID in meth load"+id);
        resp.setHeader("Content-Disposition", "attachment; filename=" + id +"_tickets.pdf");
        resp.setContentType("application/pdf");
        return "loadBatch";
    }

}
