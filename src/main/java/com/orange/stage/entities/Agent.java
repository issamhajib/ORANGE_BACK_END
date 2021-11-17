package com.orange.stage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Agent {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;

    private String nom ;
    private String prenom ;
    private String username ;
    private String password ;
    private String email ;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance ;

    private String numPhone ;

    @OneToMany(mappedBy = "agent",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<HistoriqueConnexion> historiqueConnexions ;

    @OneToMany(mappedBy = "agent",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Incident> incidents ;

    public Agent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNumPhone() {
        return numPhone;
    }

    public void setNumPhone(String numPhone) {
        this.numPhone = numPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<HistoriqueConnexion> getHistoriqueConnexions() {
        return historiqueConnexions;
    }

    public void setHistoriqueConnexions(List<HistoriqueConnexion> historiqueConnexions) {
        this.historiqueConnexions = historiqueConnexions;
    }

    public List<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<Incident> incidents) {
        this.incidents = incidents;
    }
}
