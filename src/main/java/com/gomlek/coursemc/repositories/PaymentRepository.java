package com.gomlek.coursemc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gomlek.coursemc.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
