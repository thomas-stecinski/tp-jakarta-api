package com.example.OlympiqueAPI.Controller;

import com.example.OlympiqueAPI.Model.Stadium;
import com.example.OlympiqueAPI.Service.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/stadiums")
public class StadiumController {

    @Autowired
    private StadiumService stadiumService;

    @PostMapping
    public ResponseEntity<?> createStadium(@RequestBody Stadium stadium) {
        return ResponseEntity.ok(stadiumService.save(stadium));
    }

    @GetMapping
    public ResponseEntity<?> getAllStadiums() {
        return ResponseEntity.ok(stadiumService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStadiumById(@PathVariable Long id) {
        Optional<Stadium> stadium = stadiumService.findById(id);
        if (stadium.isPresent()) {
            return ResponseEntity.ok(stadium.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStadium(@PathVariable Long id, @RequestBody Stadium stadiumDetails) {
        Optional<Stadium> stadium = stadiumService.findById(id);
        if (stadium.isPresent()) {
            Stadium updatedStadium = stadium.get();
            updatedStadium.setName(stadiumDetails.getName());
            updatedStadium.setLocation(stadiumDetails.getLocation());
            updatedStadium.setCapacity(stadiumDetails.getCapacity());
            return ResponseEntity.ok(stadiumService.save(updatedStadium));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStadium(@PathVariable Long id) {
        stadiumService.delete(id);
        return ResponseEntity.ok().build();
    }
}
