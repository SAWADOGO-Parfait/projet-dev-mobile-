package com.example.direction.data.local.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Ignore;
import androidx.annotation.NonNull;

@Entity(tableName = "services")
public class Service {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String nom;

    private String description;
    private String responsable;
    private int nombreAgents;

    // Constructeur par défaut OBLIGATOIRE
    public Service() {
        this.nom = "";
        this.description = "";
        this.responsable = "";
        this.nombreAgents = 0;
    }

    // Constructeur avec paramètres - MARQUER AVEC @Ignore
    @Ignore
    public Service(@NonNull String nom, String description, String responsable) {
        this();
        this.nom = nom;
        this.description = description;
        this.responsable = responsable;
    }

    // GETTERS ET SETTERS
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @NonNull
    public String getNom() { return nom; }
    public void setNom(@NonNull String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }

    public int getNombreAgents() { return nombreAgents; }
    public void setNombreAgents(int nombreAgents) { this.nombreAgents = nombreAgents; }
}