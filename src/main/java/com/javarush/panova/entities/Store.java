package com.javarush.panova.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id", columnDefinition = "tinyint UNSIGNED not null")
    private Short id;

    @OneToOne
    @JoinColumn(name = "manager_staff_id", nullable = false, columnDefinition = "unsigned", unique = true)
    private Staff managerStaff;

    @OneToOne( optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false, columnDefinition = "unsigned")
    private Address address;

    @Column(name = "last_update", nullable = false)
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Staff getManagerStaff() {
        return managerStaff;
    }

    public void setManagerStaff(Staff managerStaff) {
        this.managerStaff = managerStaff;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Store store = (Store) object;
        return Objects.equals(id, store.id) && Objects.equals(managerStaff, store.managerStaff) && Objects.equals(address, store.address) && Objects.equals(lastUpdate, store.lastUpdate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(managerStaff);
        result = 31 * result + Objects.hashCode(address);
        result = 31 * result + Objects.hashCode(lastUpdate);
        return result;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", managerStaffId=" + managerStaff.getId() +
                ", address=" + address +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}