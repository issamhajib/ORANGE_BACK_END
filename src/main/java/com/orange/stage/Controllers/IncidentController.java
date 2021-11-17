package com.orange.stage.Controllers;

import com.orange.stage.entities.Equipe;
import com.orange.stage.entities.Incident;
import com.orange.stage.entities.Membre;
import com.orange.stage.repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incident")
public class IncidentController {

    @Autowired
    IncidentRepository incidentRepository ;

    @GetMapping("/all")
    public List<Incident> findAll(){
        return incidentRepository .findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Incident incident){
        incidentRepository .save(incident);
    }



}
