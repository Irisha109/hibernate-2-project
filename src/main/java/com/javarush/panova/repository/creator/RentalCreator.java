package com.javarush.panova.repository.creator;

import com.javarush.panova.entities.Customer;
import com.javarush.panova.entities.Inventory;
import com.javarush.panova.entities.Rental;
import com.javarush.panova.entities.Staff;

public class RentalCreator {
    private Inventory inventory;
    private Customer customer;
    private Staff staff;

    public RentalCreator(Inventory inventory, Customer customer, Staff staff) {
        this.inventory = inventory;
        this.customer = customer;
        this.staff = staff;
    }
    public Rental createRental(){
        return new Rental(inventory, customer, staff);

    }
}
