package com.gomlek.coursemc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.gomlek.coursemc.entities.Category;

import org.hibernate.validator.constraints.Length;



public class CategoryDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    private Long id;
    
    @NotNull(message = "mandatory filling")
    @Length(min=5, max=80, message= "the size soould be between 5 and 80")
    private String name;

    public CategoryDTO(){
    }

    public CategoryDTO(Category obj){
        id = obj.getId();
        name = obj.getName();
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

}
