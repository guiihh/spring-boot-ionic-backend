package com.gomlek.coursemc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gomlek.coursemc.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
