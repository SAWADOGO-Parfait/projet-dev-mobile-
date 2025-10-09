package com.example.direction.data.local.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import androidx.annotation.NonNull;

import com.example.direction.data.local.database.DateConverter;
import com.example.direction.data.local.database.StatutConverter;

import java.util.Date;

@Entity(tableName = "agents")
@TypeConverters({DateConverter.class, StatutConverter.class})
public class Agent {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String nomComplet;

    @NonNull
    private String service;

    private String fonction;
    private String jourSemaine;
    private Date dateArrivee;

    @NonNull
    private String statut;

    private String compteRendu;
    private Date dateCreation;
    private Date dateModification;

    // Constructeur par défaut OBLIGATOIRE pour Room
    public Agent() {
        this.nomComplet = "";
        this.service = "";
        this.statut = StatutOccupation.DISPONIBLE.name();
        this.dateCreation = new Date();
        this.dateModification = new Date();
    }

    // Constructeur avec paramètres - AJOUTER @Ignore
    public Agent(@NonNull String nomComplet, @NonNull String service, String fonction,
                 String jourSemaine, Date dateArrivee, StatutOccupation statut) {
        this();
        this.nomComplet = nomComplet;
        this.service = service;
        this.fonction = fonction;
        this.jourSemaine = jourSemaine;
        this.dateArrivee = dateArrivee;
        setStatutFromEnum(statut);
    }

    // Méthode utilitaire pour gérer l'enum
    public void setStatutFromEnum(StatutOccupation statut) {
        this.statut = statut != null ? statut.name() : StatutOccupation.DISPONIBLE.name();
    }

    public StatutOccupation getStatutAsEnum() {
        try {
            return StatutOccupation.valueOf(statut);
        } catch (IllegalArgumentException e) {
            return StatutOccupation.DISPONIBLE;
        }
    }

    // GETTERS ET SETTERS COMPLETS - TOUS DOIVENT ÊTRE PRÉSENTS

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @NonNull
    public String getNomComplet() { return nomComplet; }
    public void setNomComplet(@NonNull String nomComplet) { this.nomComplet = nomComplet; }

    @NonNull
    public String getService() { return service; }
    public void setService(@NonNull String service) { this.service = service; }

    public String getFonction() { return fonction; }
    public void setFonction(String fonction) { this.fonction = fonction; }

    public String getJourSemaine() { return jourSemaine; }
    public void setJourSemaine(String jourSemaine) { this.jourSemaine = jourSemaine; }

    public Date getDateArrivee() { return dateArrivee; }
    public void setDateArrivee(Date dateArrivee) { this.dateArrivee = dateArrivee; }

    @NonNull
    public String getStatut() { return statut; }
    public void setStatut(@NonNull String statut) {
        this.statut = statut;
        this.dateModification = new Date();
    }

    // AJOUTER LES GETTERS/SETTERS MANQUANTS
    public String getCompteRendu() { return compteRendu; }
    public void setCompteRendu(String compteRendu) { this.compteRendu = compteRendu; }

    public Date getDateCreation() { return dateCreation; }
    public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }

    public Date getDateModification() { return dateModification; }
    public void setDateModification(Date dateModification) { this.dateModification = dateModification; }
}