package com.orange.stage.repositories;

import com.orange.stage.entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepository extends JpaRepository<Equipe , Integer> {

    Equipe findById(int id) ;
}
