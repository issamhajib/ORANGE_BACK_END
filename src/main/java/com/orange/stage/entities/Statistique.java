package com.orange.stage.entities;

import com.orange.stage.repositories.EquipeRepository;
import com.orange.stage.repositories.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Statistique {
    private  int nbrTotalEquipe  ;
    private  int nbrTotalEquipeVide ;
    private  int nbrTotalMember ;
    private  int nbrTotalMemberSansEquipe ;
    private  int nbrTotalMemberAvecEquipe ;

    private int nbrTotalIncident ;
    private  int incidentEncours ;
    private  int incidentResolus ;

    public Statistique() {


    }

    public int getNbrTotalEquipeVide() {
        return nbrTotalEquipeVide;
    }

    public void setNbrTotalEquipeVide(int nbrTotalEquipeVide) {
        this.nbrTotalEquipeVide = nbrTotalEquipeVide;
    }

    public int getNbrTotalEquipe() {
        return nbrTotalEquipe;
    }

    public void setNbrTotalEquipe(int nbrTotalEquipe) {
        this.nbrTotalEquipe = nbrTotalEquipe;
    }

    public int getNbrTotalMember() {
        return nbrTotalMember;
    }

    public void setNbrTotalMember(int nbrTotalMember) {
        this.nbrTotalMember = nbrTotalMember;
    }

    public int getNbrTotalIncident() {
        return nbrTotalIncident;
    }

    public void setNbrTotalIncident(int nbrTotalIncident) {
        this.nbrTotalIncident = nbrTotalIncident;
    }

    public int getIncidentEncours() {
        return incidentEncours;
    }

    public void setIncidentEncours(int incidentEncours) {
        this.incidentEncours = incidentEncours;
    }

    public int getIncidentResolus() {
        return incidentResolus;
    }

    public void setIncidentResolus(int incidentResolus) {
        this.incidentResolus = incidentResolus;
    }

    public int getNbrTotalMemberSansEquipe() {
        return nbrTotalMemberSansEquipe;
    }

    public void setNbrTotalMemberSansEquipe(int nbrTotalMemberSansEquipe) {
        this.nbrTotalMemberSansEquipe = nbrTotalMemberSansEquipe;
    }

    public int getNbrTotalMemberAvecEquipe() {
        return nbrTotalMemberAvecEquipe;
    }

    public void setNbrTotalMemberAvecEquipe(int nbrTotalMemberAvecEquipe) {
        this.nbrTotalMemberAvecEquipe = nbrTotalMemberAvecEquipe;
    }
}
