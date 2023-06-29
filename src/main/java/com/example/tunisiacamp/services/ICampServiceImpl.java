package com.example.tunisiacamp.services;

import com.example.tunisiacamp.entites.Evenement;
import com.example.tunisiacamp.repositories.EventRepository;

import java.util.List;

public class ICampServiceImpl implements ICampService {

    EventRepository eventRepository;
    @Override
    public Evenement addEvent(Evenement e) {
        return eventRepository.save(e);
    }

    @Override
    public Evenement updateEvent(Evenement e) {
        return eventRepository.save(e);
    }


    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<Evenement> getAllEvent() {
        return eventRepository.findAll();
    }




}
