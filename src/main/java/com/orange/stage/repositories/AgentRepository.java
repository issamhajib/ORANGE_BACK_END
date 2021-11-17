package com.orange.stage.repositories;

import com.orange.stage.entities.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AgentRepository extends JpaRepository<Agent , Integer> {

    Agent findById(int id) ;

}
