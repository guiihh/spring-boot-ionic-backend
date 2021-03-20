package com.gomlek.coursemc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gomlek.coursemc.entities.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long>{

}
