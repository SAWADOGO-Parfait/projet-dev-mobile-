package com.example.direction.ui.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.direction.data.repository.AgentRepository;
import com.example.direction.data.local.database.entities.Agent;

import java.util.List;

public class AgentViewModel extends AndroidViewModel {
    private AgentRepository repository;
    private LiveData<List<Agent>> allAgents;
    private MutableLiveData<String> searchQuery = new MutableLiveData<>();

    public AgentViewModel(Application application) {
        super(application);
        repository = new AgentRepository(application);
        allAgents = repository.getAllAgents();
    }

    public LiveData<List<Agent>> getAllAgents() {
        return allAgents;
    }

    public void insert(Agent agent) {
        repository.insert(agent);
    }

    public void update(Agent agent) {
        repository.update(agent);
    }

    public void delete(Agent agent) {
        repository.delete(agent);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public MutableLiveData<String> getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String query) {
        searchQuery.setValue(query);
    }
}