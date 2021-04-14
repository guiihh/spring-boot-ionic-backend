package com.gomlek.coursemc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gomlek.coursemc.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

        
}
