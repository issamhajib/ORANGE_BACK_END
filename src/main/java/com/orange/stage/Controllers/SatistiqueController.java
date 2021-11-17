package com.orange.stage.Controllers;

import com.orange.stage.entities.Equipe;
import com.orange.stage.entities.Membre;
import com.orange.stage.entities.Statistique;
import com.orange.stage.repositories.EquipeRepository;
import com.orange.stage.repositories.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/statistique")
public class SatistiqueController {

    @Autowired
    private EquipeRepository equipeRepository ;
    @Autowired
    private MembreRepository membreRepository ;

    MembreController mc = new MembreController() ;

    /*@GetMapping("/first")
public Statistique findAll(){

        Statistique st = new Statistique() ;
       st.setNbrTotalMember(membreRepository.findAll().size());
       st.setNbrTotalEquipe(equipeRepository.findAll().size());
        List<Membre> mse = new ArrayList<>();
        for(Membre m : membreRepository.findAll()){
            if(m.getEquipe()==null && mse.indexOf(m)<0){
                mse.add(m) ;
            }
        }

        List<Equipe> eq = new ArrayList<>();
        for (Equipe e : equipeRepository.findAll()){
            if(e.getMembres().size()==0 && eq.indexOf(e)<0){
                eq.add(e);
            }
        }
        st.setNbrTotalEquipeVide(eq.size());
       st.setNbrTotalMemberAvecEquipe(membreRepository.findAll().size()-mse.size());
       st.setNbrTotalMemberSansEquipe(mse.size());

        return st ;
    }*/
}
