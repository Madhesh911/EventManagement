package com.example.relation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.relation.model.RegisterModel;

public interface RegisterRepo extends JpaRepository<RegisterModel,Integer>{

    @Query("SELECT r FROM RegisterModel r WHERE r.userName = :userName")
    RegisterModel findByUserName(String userName);
    
    
}
