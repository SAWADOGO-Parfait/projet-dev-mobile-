package com.example.direction.data.local.database;

import androidx.room.TypeConverter;

// Si le dossier s'appelle "entities"
import com.example.direction.data.local.database.entities.StatutOccupation;

// Si le dossier s'appelle "entites"
// import com.example.direction.data.local.database.entites.StatutOccupation;

public class StatutConverter {

    @TypeConverter
    public static String fromStatut(StatutOccupation statut) {
        if (statut == null) {
            return null;
        }
        return statut.name();
    }

    @TypeConverter
    public static StatutOccupation toStatut(String value) {
        if (value == null) {
            return null;
        }
        try {
            return StatutOccupation.valueOf(value);
        } catch (IllegalArgumentException e) {
            return StatutOccupation.DISPONIBLE;
        }
    }
}