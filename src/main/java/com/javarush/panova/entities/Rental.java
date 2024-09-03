package com.javarush.panova.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id", nullable = false)
    private Integer id;

    @Column(name = "rental_date", nullable = false)
    private LocalDateTime rentalDate;

    @ManyToOne
    @JoinColumn(name = "inventory_id", nullable = false, columnDefinition = "unsigned")
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, columnDefinition = "unsigned")
    private Customer customer;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false, columnDefinition = "unsigned")
    private Staff staff;

    @Column(name = "last_update", nullable = false)
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    public Rental() {
    }

    public Rental(Inventory inventory, Customer customer, Staff staff) {
        this.rentalDate = LocalDateTime.now();
        this.inventory = inventory;
        this.customer = customer;
        this.staff = staff;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Rental rental = (Rental) object;
        return Objects.equals(id, rental.id) && Objects.equals(rentalDate, rental.rentalDate) && Objects.equals(inventory, rental.inventory) && Objects.equals(customer, rental.customer) && Objects.equals(returnDate, rental.returnDate) && Objects.equals(staff, rental.staff) && Objects.equals(lastUpdate, rental.lastUpdate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(rentalDate);
        result = 31 * result + Objects.hashCode(inventory);
        result = 31 * result + Objects.hashCode(customer);
        result = 31 * result + Objects.hashCode(returnDate);
        result = 31 * result + Objects.hashCode(staff);
        result = 31 * result + Objects.hashCode(lastUpdate);
        return result;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", rentalDate=" + rentalDate +
                ", inventory=" + inventory +
                ", customer=" + customer +
                ", returnDate=" + returnDate +
                ", staff=" + staff +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}