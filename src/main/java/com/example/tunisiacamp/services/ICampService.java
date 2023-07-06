package com.example.tunisiacamp.services;

import com.example.tunisiacamp.entites.Evenement;

import java.util.List;

public interface ICampService {

    public Evenement addEvent (Evenement e);

    public Evenement updateEvent (Evenement e);
    public void deleteEvent (Long id);

    public Evenement getEventById(Long id);
    public List<Evenement> getAllEvents();


}

