package com.example.relation.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.relation.model.EventModel;
import com.example.relation.model.RegisterModel;
import com.example.relation.repository.EventRepo;

@Service
public class EventService {
    

    private EventRepo eventRepo;

    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }


    public boolean saveProduct(EventModel eventModel)
    {
        try {
                eventRepo.save(eventModel);
            
            } 
            catch (Exception e) {
               return false;
            }
            return true;
        
    }

    public EventModel getProduct(int id)
    {
        return eventRepo.findById(id).orElse(null);
    }



    public List<EventModel> getAllDetails()
    {
        return eventRepo.findAll();
    }


    public boolean updateProduct(int id,EventModel eventModel)
    {
        if(this.getProduct(id)==null)
        {
            return false;
        }
        try {
                    eventRepo.save(eventModel);
            } 
            catch (Exception e) {
               return false;
            }
            return true;
        
    }


    public boolean deleteProduct(int id)
    {
        if(this.getProduct(id)==null)
        {
            return false;
        }
        try {
                    eventRepo.deleteById(id);
            } 
            catch (Exception e) {
               return false;
            }
            return true;
    }


    public List<EventModel> getManagerByName(String managerName)
    {
        return eventRepo.findByManagerName(managerName);
    }
}
