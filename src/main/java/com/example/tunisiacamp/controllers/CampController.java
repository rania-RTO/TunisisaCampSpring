package com.example.tunisiacamp.controllers;


import com.example.tunisiacamp.entites.Evenement;
import com.example.tunisiacamp.services.ICampService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class CampController {

    ICampService iCampService;

    @PostMapping("/add_event")
    public Evenement addClinique (@RequestBody Evenement e) {
        return iCampService.addEvent(e);
    }


    @PostMapping("/delete_event/{id}")
    public void deleteEvent(@PathVariable("id") Long id) {

            iCampService.deleteEvent(id);
    }

    @PutMapping("/update_event/{id}")
    public ResponseEntity<Evenement> updateEvent(@PathVariable("id") Long id, @RequestBody Evenement e) {
        e.setIdEvenement(id); // Assurez-vous de définir l'ID de l'événement à mettre à jour

        Evenement updatedEvent = iCampService.updateEvent(e);
        if (updatedEvent != null) {
            return ResponseEntity.ok(updatedEvent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/events")
    public List<Evenement> getAllEvents() {
        return iCampService.getAllEvents();
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<Evenement> getEventById(@PathVariable Long id) {
        Evenement evenement = iCampService.getEventById(id);
        if (evenement != null) {
            return ResponseEntity.ok(evenement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }













}
