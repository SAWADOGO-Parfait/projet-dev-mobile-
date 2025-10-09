package com.example.direction.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.direction.data.local.database.AppDatabase;
import com.example.direction.data.local.database.entities.Agent;
import com.example.direction.data.local.database.dao.AgentDao;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AgentRepository {
    private AgentDao agentDao;
    private ExecutorService executorService;

    public AgentRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        this.agentDao = database.agentDao();
        this.executorService = Executors.newFixedThreadPool(2);
    }

    // Méthodes LiveData pour l'observation
    public LiveData<List<Agent>> getAllAgents() {
        return agentDao.getAllAgents();
    }

    // Méthodes pour les opérations asynchrones
    public void insert(Agent agent) {
        executorService.execute(() -> {
            long id = agentDao.insert(agent);
            // Mettre à jour le compteur d'agents du service
            updateServiceAgentCount(agent.getService());
        });
    }

    public void update(Agent agent) {
        executorService.execute(() -> {
            agentDao.update(agent);
            // Mettre à jour le compteur d'agents du service
            updateServiceAgentCount(agent.getService());
        });
    }

    public void delete(Agent agent) {
        executorService.execute(() -> {
            agentDao.delete(agent);
            // Mettre à jour le compteur d'agents du service
            updateServiceAgentCount(agent.getService());
        });
    }

    public void deleteById(int id) {
        executorService.execute(() -> {
            Agent agent = agentDao.getAgentById(id);
            if (agent != null) {
                agentDao.deleteById(id);
                updateServiceAgentCount(agent.getService());
            }
        });
    }

    // Méthodes de recherche
    public LiveData<List<Agent>> searchAgents(String query) {
        // Note: Vous devrez adapter pour retourner LiveData
        // Pour l'instant, retourne tous les agents
        return agentDao.getAllAgents();
    }

    public List<Agent> getAgentsByService(String service) {
        return agentDao.getAgentsByService(service);
    }

    public List<Agent> getAgentsByStatut(String statut) {
        return agentDao.getAgentsByStatut(statut);
    }

    // Mettre à jour le compteur d'agents d'un service
    private void updateServiceAgentCount(String serviceName) {
        int count = agentDao.getAgentCountByService(serviceName);
        // Vous devrez implémenter la mise à jour dans ServiceDao
    }
}