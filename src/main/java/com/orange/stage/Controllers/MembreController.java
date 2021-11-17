package com.orange.stage.Controllers;

import com.orange.stage.entities.Equipe;
import com.orange.stage.entities.Membre;
import com.orange.stage.repositories.EquipeRepository;
import com.orange.stage.repositories.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/membre")
public class MembreController {

    @Autowired
    private MembreRepository membreRepository ;
    @Autowired
    private EquipeRepository equipeRepository ;


    @GetMapping("/all")
    public List<Membre> findAll(){
        return membreRepository.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Membre membre){
        membreRepository.save(membre);
    }

    @PostMapping("/addmberToATeam/{i}/{ii}")
    public void ajouterMember(@PathVariable (required = true) String i,@PathVariable (required = true) String ii){
        int idmember = Integer.parseInt(i);
        int idequipe = Integer.parseInt(ii);
        Membre membre = membreRepository.findById(idmember);
        Equipe equipe = equipeRepository.findById(idequipe) ;

        List<Equipe> equipes = membre.getEquipes() ;
        if(equipes.indexOf(equipe)<0){
            equipes.add(equipe);
            membre.setEquipes(equipes);
            membreRepository.save(membre) ;
        }

        List<Membre> membres = equipe.getMembres() ;
        if(membres.indexOf(membre)<0){
            membres.add(membre) ;

            equipe.setMembres(membres);

            equipeRepository.save(equipe) ;
        }


    }

    @PostMapping("/deletmemberfromATeam/{i}/{ii}")
    public boolean retirer(@PathVariable (required = true) String i ,@PathVariable (required = true) String ii){
        int idmember = Integer.parseInt(i);
        int idequipe = Integer.parseInt(ii);
        Membre membre = membreRepository.findById(idmember);
        Equipe equipe = equipeRepository.findById(idequipe) ;

        List<Equipe> equipes = membre.getEquipes() ;
        if(equipes.indexOf(equipe)>=0){
            equipes.remove(equipe) ;
            membre.setEquipes(equipes);
            membreRepository.save(membre) ;
        }

        List<Membre> membres = equipe.getMembres() ;
        if(membres.indexOf(membre)>=0){
            membres.remove(membre) ;
            equipe.setMembres(membres);
            equipeRepository.save(equipe) ;
        }
        System.out.println((membres.indexOf(membre)<0)+ " "+ (equipes.indexOf(equipe)<0));
        return (membres.indexOf(membre)<0 && equipes.indexOf(equipe)<0);
    }
    @GetMapping("/membersSansEquipe/{i}")
    public List<Membre> membersSansEquipe(@PathVariable (required = true) String i){
        int idequipe = Integer.parseInt(i);
        Equipe equipe = equipeRepository.findById(idequipe) ;
        List<Membre> mse = new ArrayList<>();
        for(Membre m : membreRepository.findAll()){
            if(equipe.getMembres().indexOf(m)<0){
                mse.add(m) ;
            }
        }
         return mse;
    }



    @GetMapping("/getEquipOf/{i}")
    public List<Equipe> equipeOfMember(@PathVariable (required = true) String i){
        int id = Integer.parseInt(i);
        Membre membre = membreRepository.findById(id);
        return membre.getEquipes();
    }



    @GetMapping("/getMember/{i}")
    public Membre getMemberById(@PathVariable (required = true) String i){
        int id = Integer.parseInt(i);
        Membre membre = membreRepository.findById(id);
        return membre;
    }

    @DeleteMapping("/deleteEquipe/{i}")
    public Boolean deleteEquipe(@PathVariable (required = true) String i){
        int idequipe = Integer.parseInt(i);
        Equipe equipe = equipeRepository.findById(idequipe) ;

        ArrayList<Membre> membres = new ArrayList<>() ;
        membres.addAll(equipe.getMembres());

        for (Membre membre : membres){
            if(membre.getEquipes().indexOf(equipe)>=0 && equipe.getMembres().indexOf(membre)>=0 ){
                String idmember = String.valueOf(membre.getId()) ;
                this.retirer(idmember , i);
            } }
        equipeRepository.delete(equipe);

      return true ;
    }

    @DeleteMapping("/deleteMember/{i}")
    public Boolean deleteMember(@PathVariable (required = true) String i){
        int id = Integer.parseInt(i);
        Membre membre = membreRepository.findById(id);

        ArrayList<Equipe> equipes = new ArrayList<>() ;
        equipes.addAll(membre.getEquipes());

        for (Equipe equipe : equipes){
            if(membre.getEquipes().indexOf(equipe)>=0 && equipe.getMembres().indexOf(membre)>=0 ){
                String idequipe = String.valueOf(equipe.getId()) ;
                this.retirer(i , idequipe );
            } }
        membreRepository.delete(membre);
        return true ;
    }








}
