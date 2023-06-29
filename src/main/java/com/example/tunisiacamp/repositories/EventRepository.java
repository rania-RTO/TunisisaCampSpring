package com.example.tunisiacamp.repositories;

import com.example.tunisiacamp.entites.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Evenement, Long> {
}
