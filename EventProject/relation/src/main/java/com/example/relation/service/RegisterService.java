package com.example.relation.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.relation.model.RegisterModel;
import com.example.relation.repository.RegisterRepo;

@Service
public class RegisterService {
    

    private RegisterRepo registerRepo;

    public RegisterService(RegisterRepo registerRepo) {
        this.registerRepo = registerRepo;
    }
    
    public boolean saveRegister(RegisterModel registerModel)
    {
        try {
                registerRepo.save(registerModel);
            
            } 
            catch (Exception e) {
               return false;
            }
            return true;
        
    }

    public RegisterModel getRegister(int id)
    {
        return registerRepo.findById(id).orElse(null);
    }

    public List<RegisterModel> getAllDetails()
    {
        return registerRepo.findAll();
    }


    public boolean updateRegister(int id,RegisterModel registerModel)
    {
        if(this.getRegister(id)==null)
        {
            return false;
        }
        try {
                    registerRepo.save(registerModel);
            } 
            catch (Exception e) {
               return false;
            }
            return true;
        
    }

    public boolean deleteRegister(int id)
    {
        if(this.getRegister(id)==null)
        {
            return false;
        }
        try {
                    registerRepo.deleteById(id);
            } 
            catch (Exception e) {
               return false;
            }
            return true;
    }


    public RegisterModel getRegisterByName(String userName) {
        RegisterModel r = registerRepo.findByUserName(userName);
        return r; 
    }

     public List<RegisterModel> getSortedList(String field) {
        return registerRepo.findAll(Sort.by(Sort.Direction.ASC, field));
    }


     public List<RegisterModel> getPageList(int offset, int pagesize) {
        Page<RegisterModel> k = registerRepo.findAll(PageRequest.of(offset, pagesize));
        return k.getContent();
    }
    


}
