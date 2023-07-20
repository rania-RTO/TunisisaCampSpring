package com.example.tunisiacamp.services;

import com.example.tunisiacamp.entites.Evenement;
import com.example.tunisiacamp.entites.Panier;

import java.util.List;

public interface ICampService {

    public Evenement addEvent (Evenement e);

    public Evenement updateEvent (Evenement e);
    public void deleteEvent (Long id);

    public Evenement getEventById(Long id);
    public List<Evenement> getAllEvents();


    Panier addPanier(Panier p);
    public void deletePanier( Long id);

    Panier getPanier(Long id);

    void ajouterEvenementAuPanier(Long panierId, Evenement event);

    List<Panier> getAllpanier();

    void deleteEventFromPanier(Long panierId, Long eventId);
}

