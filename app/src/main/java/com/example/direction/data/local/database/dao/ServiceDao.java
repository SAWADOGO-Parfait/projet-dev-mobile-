package com.example.direction.data.local.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.direction.data.local.database.entities.Service;

import java.util.List;

@Dao
public interface ServiceDao {

    @Insert
    long insert(Service service);

    @Query("SELECT * FROM services ORDER BY nom ASC")
    LiveData<List<Service>> getAllServices();

    @Query("SELECT * FROM services ORDER BY nom ASC")
    List<Service> getAllServicesList();

    @Query("SELECT * FROM services WHERE id = :id")
    Service getServiceById(int id);

    @Query("UPDATE services SET nombreAgents = :count WHERE id = :serviceId")
    void updateAgentCount(int serviceId, int count);

    @Query("DELETE FROM services WHERE id = :id")
    void deleteById(int id);

    // Nouvelles méthodes
    @Query("SELECT COUNT(*) FROM services")
    int getTotalServices();

    @Query("SELECT * FROM services WHERE nom LIKE '%' || :search || '%'")
    List<Service> searchServices(String search);
}