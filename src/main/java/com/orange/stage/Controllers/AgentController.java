package com.orange.stage.Controllers;

import com.orange.stage.entities.Agent;
import com.orange.stage.entities.HistoriqueConnexion;
import com.orange.stage.entities.Incident;
import com.orange.stage.entities.Membre;
import com.orange.stage.repositories.AgentRepository;
import com.orange.stage.repositories.HistoriqueConnexionRepository;
import com.orange.stage.repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/agent")
public class AgentController {

    @Autowired
    private AgentRepository agentRepository ;

    @Autowired
    IncidentRepository incidentRepository ;

    @Autowired
    private HistoriqueConnexionRepository historiqueConnexionRepository ;

    @GetMapping("/all")
    public List<Agent> findAll(){
        return agentRepository.findAll();
    }

    @GetMapping("/incidentDeclarerParAgent/{i}")
    public List<Incident> AgentIncidents(@PathVariable (required = true) String i){
        int idagent = Integer.parseInt(i) ;
        Agent agent = agentRepository.findById(idagent) ;
        List<Incident> incidents = new ArrayList<>();

        for( Incident incident : incidentRepository.findAll()){
            if(incident.getAgent().equals(agent) &&incidents.indexOf(incident)<0){
                 incidents.add(incident) ;
            }
        }

        return incidents ;
    }

    @PostMapping("/save")
    public boolean save(@RequestBody Agent agent){
        boolean a = false ;
        agent.setUsername(agent.getPrenom().substring(0,2)+'.'+agent.getNom());
        if(agent.equals(agentRepository.save(agent))){
            a=true ;
        }
        return a ;
    }

    @GetMapping(value = "/verification/{username}/{password}")
    public boolean verification(@PathVariable (required = true) String username , @PathVariable (required = true) String password) throws ParseException {

        boolean verification = false ;
        for(Agent a : agentRepository.findAll()){
            if(a.getPassword().equals(password) && a.getUsername().equals(username)){
                HistoriqueConnexion historiqueConnexion = new HistoriqueConnexion() ;

                Date date = Calendar.getInstance().getTime();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
                String strDate = dateFormat.format(date);

                System.out.println("------------------");
                System.out.println("------"+strDate+"-----");
                System.out.println("------------------");
                historiqueConnexion.setDateConnexion(strDate);
                historiqueConnexion.setAgent(a);

                historiqueConnexionRepository.save(historiqueConnexion);
                verification = true ;

            }
        }
        return verification ;
    }

    @GetMapping(value = "/getAgent/{username}/{password}")
        public Agent getAgent(@PathVariable (required = true) String username , @PathVariable (required = true) String password) throws ParseException {

        Agent agent = new Agent();
        for (Agent a : agentRepository.findAll()) {
            if (a.getPassword().equals(password) && a.getUsername().equals(username)) {

               agent = a ;
            }
        }
        return agent ;
    }



}
