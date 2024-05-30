package com.example.OlympiqueAPI.Controller;

import com.example.OlympiqueAPI.Model.Ticket;
import com.example.OlympiqueAPI.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<?> purchaseTickets(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketService.purchaseTicket(ticket));
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<?> getTicketsByEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(ticketService.findTicketsByEventId(eventId));
    }
}
