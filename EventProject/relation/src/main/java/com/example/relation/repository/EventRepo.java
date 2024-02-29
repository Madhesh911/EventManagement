package com.example.relation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.relation.model.EventModel;

public interface EventRepo extends JpaRepository<EventModel,Integer>{
    
    @Query("SELECT r FROM EventModel r WHERE r.managerName = :managerName")
    List<EventModel> findByManagerName(String managerName);
    
}
