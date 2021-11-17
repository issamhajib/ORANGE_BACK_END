package com.orange.stage.repositories;

import com.orange.stage.entities.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident, Integer> {

    Incident findById(int id) ;
}
