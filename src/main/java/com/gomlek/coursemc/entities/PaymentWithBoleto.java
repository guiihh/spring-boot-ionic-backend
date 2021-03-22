package com.gomlek.coursemc.entities;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gomlek.coursemc.entities.enums.PaymentStatus;

@Entity
public class PaymentWithBoleto extends Payment {

    private static final long serialVersionUID = 1L;
  
    @JsonFormat(pattern = "dd/HH/yyyy HH:mm")
    private Date dueDate;
    @JsonFormat(pattern = "dd/HH/yyyy HH:mm")
    private Date PaymentDate;

    public PaymentWithBoleto(){
    }

    public PaymentWithBoleto(Long id, PaymentStatus paymentStatus, Order order, Date dueDate, Date paymentDate) {
        super(id, paymentStatus, order);
        this.dueDate = dueDate;
        PaymentDate = paymentDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        PaymentDate = paymentDate;
    }



    
}
