package com.javarush.panova.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(schema = "movies", name = "category")
public class Category {
    @Id
    @Column(name = "category_id", columnDefinition = "tinyint UNSIGNED not null")
    private Short id;

    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Film> filmSet = new HashSet<>();

    @Column(name = "last_update", nullable = false)
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        Category category = (Category) object;
        return Objects.equals(id, category.id) && Objects.equals(name, category.name) && Objects.equals(filmSet, category.filmSet) && Objects.equals(lastUpdate, category.lastUpdate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(filmSet);
        result = 31 * result + Objects.hashCode(lastUpdate);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", filmSet=" + filmSet +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
