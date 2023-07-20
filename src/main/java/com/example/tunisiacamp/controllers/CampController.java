package com.example.tunisiacamp.controllers;


import com.example.tunisiacamp.entites.Evenement;
import com.example.tunisiacamp.entites.Panier;
import com.example.tunisiacamp.services.ICampService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class CampController {

    ICampService iCampService;

    @PostMapping("/add_event")
    public Evenement addEvent (@RequestBody Evenement e) {
        return iCampService.addEvent(e);
    }

    @CrossOrigin("http://localhost:4200")
    @DeleteMapping("/delete_event/{id}")
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




    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/events/{id}")
    public ResponseEntity<Evenement> getEventById(@PathVariable Long id) {
        Evenement evenement = iCampService.getEventById(id);
        if (evenement != null) {
            return ResponseEntity.ok(evenement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @PostMapping("/add_panier")
    public Panier addPanier (@RequestBody Panier p) {
        return iCampService.addPanier(p);
    }

    @GetMapping("/panier/{id}")
    public Panier getPanier(@PathVariable Long id) {
        return iCampService.getPanier(id);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/{panierId}/addEvent")
    public ResponseEntity<String> ajouterEvenementAuPanier(
            @PathVariable Long panierId,
            @RequestBody Evenement event) {

        iCampService.ajouterEvenementAuPanier(panierId, event);
        return ResponseEntity.ok("Événement ajouté au panier avec succès.");
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/panier")
    public List<Panier> getAllpanier() {
        return iCampService.getAllpanier();
    }

    @PostMapping("/delete/{id}")
    public void deletePanier(@PathVariable("id") Long id) {
        iCampService.deletePanier(id);
    }

    @DeleteMapping("/panier/{panierId}/{eventId}")
    public void deleteEventFromPanier(@PathVariable Long panierId, @PathVariable Long eventId) {
        iCampService.deleteEventFromPanier(panierId, eventId);
    }



}
