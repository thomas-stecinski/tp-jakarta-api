package com.example.OlympiqueAPI.Service;

import com.example.OlympiqueAPI.Model.Event;
import com.example.OlympiqueAPI.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public Event update(Long id, Event eventDetails) {
        return eventRepository.findById(id).map(event -> {
            event.setName(eventDetails.getName());
            event.setDate(eventDetails.getDate());
            event.setStadium(eventDetails.getStadium());
            event.setTickets(eventDetails.getTickets());
            event.setClosed(eventDetails.isClosed());
            return eventRepository.save(event);
        }).orElseThrow(() -> new IllegalArgumentException("Event not found"));
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

    public Event closeRegistration(Long id) {
        return eventRepository.findById(id).map(event -> {
            event.setClosed(true);
            return eventRepository.save(event);
        }).orElseThrow(() -> new IllegalArgumentException("Event not found"));
    }
}
