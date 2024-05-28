package com.example.OlympiqueAPI.Service;

import com.example.OlympiqueAPI.Model.Event;
import com.example.OlympiqueAPI.Model.Ticket;
import com.example.OlympiqueAPI.Repository.EventRepository;
import com.example.OlympiqueAPI.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final EventRepository eventRepository; 

    @Autowired
    public TicketService(TicketRepository ticketRepository, EventRepository eventRepository) {
        this.ticketRepository = ticketRepository;
        this.eventRepository = eventRepository;
    }

    public Ticket purchaseTicket(Ticket ticket) {
        Optional<Event> eventOptional = eventRepository.findById(ticket.getEvent().getId());
        if (!eventOptional.isPresent() || eventOptional.get().isClosed()) {
            throw new IllegalStateException("L'event n'est pas dispo, les inscriptions sont fermées");
        }

        List<Ticket> existingTickets = ticketRepository.findByUserId(ticket.getUser().getId());
        for (Ticket existingTicket : existingTickets) {
            if (existingTicket.getEvent().getDate().equals(ticket.getEvent().getDate())) {
                throw new IllegalStateException("L'user à déjà un ticket pour cette date");
            }
        }

        if (existingTickets.size() >= 5) { 
            double discountedPrice = ticket.getPrice() * 0.90; 
            ticket.setPrice(discountedPrice);
        }

        return ticketRepository.save(ticket);
    }

    public List<Ticket> findTicketsByEventId(Long eventId) {
        return ticketRepository.findByEventId(eventId);
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> findById(Long id) {
        return ticketRepository.findById(id);
    }
}
