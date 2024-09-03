package com.javarush.panova.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.Objects;

@Entity
@Table(name = "film_text")
public class FilmText {
    @Id
    @Column(name = "film_id")
    private Integer id;

    @OneToOne()
    @JoinColumn(name = "film_id",  nullable = false)
    private Film film;

    @Column(name = "title", nullable = false)
    private String title;


    @Column(name = "description", columnDefinition = "text")
    @Type(type = "text")
    private String description;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getFilm() {
        return id;
    }

    public void setFilm(Integer id) {
        this.id = id;
    }

    public FilmText() {
    }

    public FilmText(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        FilmText filmText = (FilmText) object;
        return Objects.equals(film, filmText.film) && Objects.equals(title, filmText.title) && Objects.equals(description, filmText.description);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(film);
        result = 31 * result + Objects.hashCode(title);
        result = 31 * result + Objects.hashCode(description);
        return result;
    }

    @Override
    public String toString() {
        return "FilmText{" +
                "film=" + film +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}