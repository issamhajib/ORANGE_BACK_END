package com.orange.stage.repositories;

import com.orange.stage.entities.Membre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembreRepository extends JpaRepository<Membre , Integer> {

    Membre findById(int id) ;
}
