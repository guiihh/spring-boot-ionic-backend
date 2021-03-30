package com.gomlek.coursemc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.gomlek.coursemc.entities.Client;

import org.hibernate.validator.constraints.Length;

public class ClientDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull
    @Length(min = 5, max = 120, message = "The size should be between 5 and 20")
    private String name;

    @NotNull(message = "mandatory filling")
    @Email(message = "Invalid e-mail")
    private String email;

    public ClientDTO(){
    }

    public ClientDTO(Client obj){
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }
    public ClientDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    

}
