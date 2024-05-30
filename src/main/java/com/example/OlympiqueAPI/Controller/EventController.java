package com.example.OlympiqueAPI.Controller;

import com.example.OlympiqueAPI.Model.Event;
import com.example.OlympiqueAPI.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.save(event));
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<?> updateEvent(@PathVariable Long eventId, @RequestBody Event event) {
        return ResponseEntity.ok(eventService.update(eventId, event));
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long eventId) {
        eventService.delete(eventId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{eventId}/close")
    public ResponseEntity<?> closeEventRegistration(@PathVariable Long eventId) {
        return ResponseEntity.ok(eventService.closeRegistration(eventId));
    }
}
