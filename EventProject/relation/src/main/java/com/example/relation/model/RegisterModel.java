package com.example.relation.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterModel {
    @Id
    private int regId;
    private String userName;
    private String mobileNumber;
    private String email;
    private String password;
    private String confirmPassword;


     @JsonManagedReference
    @OneToMany(mappedBy = "registerModel",cascade =CascadeType.ALL)
    private List<EventModel> event;

    
    
}
