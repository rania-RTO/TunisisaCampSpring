package com.example.tunisiacamp.services;

import com.example.tunisiacamp.entites.Evenement;
import com.example.tunisiacamp.entites.Panier;
import com.example.tunisiacamp.repositories.EventRepository;
import com.example.tunisiacamp.repositories.PanierRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ICampServiceImpl implements ICampService {

    PanierRepository panierRepository;
    EventRepository eventRepository;
    @Override
    public Evenement addEvent(Evenement e) {
        return eventRepository.save(e);
    }

    @Override
    public Evenement updateEvent(Evenement e) {
        if (e.getIdEvenement() == null) {
            return null; // Gérer le cas où l'ID de l'événement est manquant ou invalide
        }

        Optional<Evenement> existingEvent = eventRepository.findById(e.getIdEvenement());
        if (existingEvent.isPresent()) {
            Evenement updatedEvent = eventRepository.save(e);
            return updatedEvent;
        } else {
            return null; // Gérer le cas où l'événement n'est pas trouvé dans la base de données
        }
    }


    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<Evenement> getAllEvents() {
        return eventRepository.findAll();
    }

    public Evenement getEventById(Long id) {
        Optional<Evenement> optionalEvenement = eventRepository.findById(id);
        return optionalEvenement.orElse(null);
    }



    @Override
    public void ajouterEvenementAuPanier(Long panierId, Evenement evenement) {
        Panier panier = panierRepository.findById(panierId).orElse(null);
        panier.getEvenements().add(evenement);
        panierRepository.save(panier);
    }

    

}
