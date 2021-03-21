package com.gomlek.coursemc.entities;

import javax.persistence.Entity;

import com.gomlek.coursemc.entities.enums.PaymentStatus;

@Entity
public class CardPayment extends Payment{

    private static final long serialVersionUID = 1L;
    
    private Integer numberOfInstallments;

    public CardPayment(){
    }

    public CardPayment(Long id, PaymentStatus paymentStatus, Order order, Integer numberOfInstallments) {
        super(id, paymentStatus, order);
        this.numberOfInstallments = numberOfInstallments;
    }

    public Integer getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(Integer numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }



}
