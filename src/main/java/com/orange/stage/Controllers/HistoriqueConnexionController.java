package com.orange.stage.Controllers;

import com.orange.stage.entities.Equipe;
import com.orange.stage.entities.HistoriqueConnexion;
import com.orange.stage.repositories.HistoriqueConnexionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historiqueConnexion")
public class HistoriqueConnexionController {

    @Autowired
    private HistoriqueConnexionRepository historiqueConnexionRepository ;

    @GetMapping("/all")
    public List<HistoriqueConnexion> findAll(){
        return historiqueConnexionRepository.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody  HistoriqueConnexion historiqueConnexion){
        historiqueConnexionRepository.save(historiqueConnexion);
    }
}
