package com.orange.stage.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Incident {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;
    private String criticite ;
    private String details ;

    @ManyToOne
    private Agent  agent ;

    private Date   dateIncidents ;

    @ManyToMany
    private List<Equipe> equipes ;

    public Incident() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCriticite() {
        return criticite;
    }

    public void setCriticite(String criticite) {
        this.criticite = criticite;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Date getDateIncidents() {
        return dateIncidents;
    }

    public void setDateIncidents(Date dateIncidents) {
        this.dateIncidents = dateIncidents;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }
}
