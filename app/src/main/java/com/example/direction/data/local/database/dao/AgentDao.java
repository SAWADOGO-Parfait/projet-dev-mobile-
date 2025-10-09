package com.example.direction.data.local.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.direction.data.local.database.entities.Agent;

import java.util.List;

@Dao
public interface AgentDao {

    @Insert
    long insert(Agent agent);

    @Update
    void update(Agent agent);

    @Delete
    void delete(Agent agent);

    // Version LiveData pour l'observation en temps réel
    @Query("SELECT * FROM agents ORDER BY nomComplet ASC")
    LiveData<List<Agent>> getAllAgents();

    // Version normale pour les opérations synchrones
    @Query("SELECT * FROM agents ORDER BY nomComplet ASC")
    List<Agent> getAllAgentsList();

    @Query("SELECT * FROM agents WHERE id = :id")
    Agent getAgentById(int id);

    @Query("SELECT * FROM agents WHERE service = :service ORDER BY nomComplet ASC")
    List<Agent> getAgentsByService(String service);

    // CORRECTION : Utiliser String pour le statut (comme défini dans l'entité)
    @Query("SELECT * FROM agents WHERE statut = :statut ORDER BY nomComplet ASC")
    List<Agent> getAgentsByStatut(String statut);

    @Query("SELECT * FROM agents WHERE nomComplet LIKE '%' || :search || '%' OR fonction LIKE '%' || :search || '%'")
    List<Agent> searchAgents(String search);

    @Query("DELETE FROM agents WHERE id = :id")
    void deleteById(int id);

    @Query("SELECT COUNT(*) FROM agents WHERE service = :service")
    int getAgentCountByService(String service);

    // Nouvelles méthodes utiles
    @Query("SELECT COUNT(*) FROM agents")
    int getTotalAgents();

    @Query("SELECT DISTINCT service FROM agents ORDER BY service ASC")
    List<String> getAllServices();

    @Query("SELECT * FROM agents WHERE dateArrivee >= :startDate AND dateArrivee <= :endDate")
    List<Agent> getAgentsByDateRange(Long startDate, Long endDate);
}