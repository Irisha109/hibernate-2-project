package com.javarush.panova.repository.creator;

import com.javarush.panova.entities.Address;
import com.javarush.panova.entities.Customer;
import com.javarush.panova.entities.Store;
import jakarta.persistence.Column;

public class CustomerCreator {
    private Store store;
    private String firstName;
    private String lastName;
    private Address address;
    private Boolean active;

    public CustomerCreator(Store store, String firstName, String lastName, Address address, Boolean active) {
        this.store = store;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.active = active;
    }
    public Customer createCustomer(){
        return new Customer(store, firstName, lastName, address, active);
    }
}
