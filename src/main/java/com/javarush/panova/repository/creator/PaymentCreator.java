package com.javarush.panova.repository.creator;

import com.javarush.panova.entities.Customer;
import com.javarush.panova.entities.Payment;
import com.javarush.panova.entities.Rental;
import com.javarush.panova.entities.Staff;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentCreator {
   private Customer customer;
   private Staff staff;
   private Rental rental;
   private BigDecimal amount;

    public PaymentCreator(Customer customer, Staff staff, Rental rental, BigDecimal amount) {
        this.customer = customer;
        this.staff = staff;
        this.rental = rental;
        this.amount = amount;

    }
    public Payment createPayment(){
        Payment payment = new Payment(customer, staff, rental, amount);
        payment.setPaymentDate(LocalDateTime.now());
        return payment;

    }
}
