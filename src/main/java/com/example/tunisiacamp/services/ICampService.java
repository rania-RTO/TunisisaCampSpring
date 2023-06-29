package com.example.tunisiacamp.services;

import com.example.tunisiacamp.entites.Evenement;

import java.util.List;

public interface ICampService {

    public Evenement addEvent (Evenement e);

    public Evenement updateEvent (Evenement e);
    public void deleteEvent (Long id);
    public List<Evenement> getAllEvent();

}

