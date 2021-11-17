package com.orange.stage.Controllers;

import com.orange.stage.entities.Equipe;
import com.orange.stage.entities.Membre;
import com.orange.stage.repositories.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/equipe")
public class EquipeController {

    @Autowired
    private EquipeRepository equipeRepository ;

    @GetMapping("/all")
    public List<Equipe> findAll(){
        return equipeRepository.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Equipe equipe){
        equipeRepository.save(equipe);
    }

    @GetMapping("/membersEquipe/{i}")
    public List<Membre> membersEquipe(@PathVariable (required = true) String i){
        int id = Integer.parseInt(i);
        return equipeRepository.findById(id).getMembres() ;
    }

    @GetMapping("/nombreMembersEquipe/{i}")
    public List<Integer> nombreMembersEquipe(@PathVariable (required = true) String i){
        int id = Integer.parseInt(i);
        List<Integer> nombreMembersEquipe = new ArrayList<>();
        for (Equipe e : equipeRepository.findAll()){
            nombreMembersEquipe.add(membersEquipe(i).size()) ;
        }
        return nombreMembersEquipe ;
    }




}
