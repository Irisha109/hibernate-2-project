package com.javarush.panova.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id", nullable = false, columnDefinition = "unsigned")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "film_id", nullable = false, columnDefinition = "unsigned")
    private Film film;

    @ManyToOne(optional = false)
    @JoinColumn(name = "store_id", nullable = false, columnDefinition = "unsigned")
    private Store store;

    @Column(name = "last_update", nullable = false)
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    public Inventory() {
    }

    public Inventory(Film film, Store store) {
        this.film = film;
        this.store = store;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
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

        Inventory inventory = (Inventory) object;
        return Objects.equals(id, inventory.id) && Objects.equals(film, inventory.film) && Objects.equals(store, inventory.store) && Objects.equals(lastUpdate, inventory.lastUpdate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(film);
        result = 31 * result + Objects.hashCode(store);
        result = 31 * result + Objects.hashCode(lastUpdate);
        return result;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", film=" + film +
                ", store=" + store +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}