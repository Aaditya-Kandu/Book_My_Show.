package com.example.BookMyShow.Controller;

import com.example.BookMyShow.EntryDTOs.TicketEntryDTO;
import com.example.BookMyShow.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/aad_ticket")
    public String addTicket(@RequestBody()TicketEntryDTO ticketEntryDTO){

       try {
           String result = ticketService.addTicket(ticketEntryDTO);
           return result;
       }catch (Exception e){

           return "Ticket is not added";
       }

    }
}
