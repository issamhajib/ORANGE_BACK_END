package com.orange.stage.entities;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class HistoriqueConnexion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;

    @ManyToOne
    private Agent agent ;


    private String dateConnexion ;

    public HistoriqueConnexion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public String getDateConnexion() {
        return dateConnexion;
    }

    public void setDateConnexion(String dateConnexion) {
        this.dateConnexion = dateConnexion;
    }
}
