package com.example.direction.data.local.database.entities;

public enum StatutOccupation {
    DISPONIBLE("Disponible"),
    OCCUPE("Occupé"),
    AUTORISATION_ABSENCE("En autorisation d'absence"),
    CONGE("En Congé");

    private final String label;

    StatutOccupation(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static StatutOccupation fromLabel(String label) {
        for (StatutOccupation statut : values()) {
            if (statut.label.equals(label)) {
                return statut;
            }
        }
        return DISPONIBLE;
    }
}