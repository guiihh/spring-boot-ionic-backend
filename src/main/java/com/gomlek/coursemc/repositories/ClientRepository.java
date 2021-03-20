package com.gomlek.coursemc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gomlek.coursemc.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
