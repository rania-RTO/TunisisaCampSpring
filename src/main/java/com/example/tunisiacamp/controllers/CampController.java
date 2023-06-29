package com.example.tunisiacamp.controllers;


import com.example.tunisiacamp.entites.Evenement;
import com.example.tunisiacamp.services.ICampService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CampController {

    ICampService iCampService;

    @PostMapping("/add_event")
    public Evenement addClinique (@RequestBody Evenement e) {
        return iCampService.addEvent(e);
    }

    @PostMapping("/delete_event/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable("id") Long id) {
        try {
            iCampService.deleteEvent(id);
            return new ResponseEntity<>("L'événement avec l'ID " + id + " a été supprimé.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Une erreur s'est produite lors de la suppression de l'événement avec l'ID " + id + ".", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }







}
