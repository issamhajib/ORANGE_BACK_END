package com.orange.stage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Equipe {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;
    private String nomEquipe ;


    @JsonIgnore
    @ManyToMany
    private List<Membre> membres ;

    public Equipe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public List<Membre> getMembres() {
        return membres;
    }

    public void setMembres(List<Membre> membres) {
        this.membres = membres;
    }
}
