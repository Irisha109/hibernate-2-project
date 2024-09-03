package com.javarush.panova.repository.creator;

import com.javarush.panova.entities.Actor;
import com.javarush.panova.entities.Category;
import com.javarush.panova.entities.Film;
import com.javarush.panova.entities.Language;
import com.javarush.panova.entities.util.Feature;
import com.javarush.panova.entities.util.Rating;
import com.javarush.panova.entities.util.RatingConverter;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class FilmCreator {

    private String title;
    private String description;
    private Integer releaseYear;
    private Language language;
    private Short rentalDuration;
    private BigDecimal rentalRate;
    private Integer length;
    private Set<Actor> actors = new HashSet<>();
    private Set<Category> categories = new HashSet<>();
    private BigDecimal replacementCost;
    private Rating rating;
    private Set<Feature> specialFeatures;

    public FilmCreator(String title, String description,  Integer releaseYear,Language language, Short rentalDuration,  BigDecimal rentalRate, Integer length, Set<Actor> actors, Set<Category> categories, BigDecimal replacementCost, Rating rating, Set<Feature> specialFeatures) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.language = language;
        this.rentalDuration = rentalDuration;

        this.rentalRate = rentalRate;
        this.length = length;
        this.actors = actors;
        this.categories = categories;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.specialFeatures = specialFeatures;
    }
    public FilmCreator(String title, String description,  Integer releaseYear,Language language, Short rentalDuration,  BigDecimal rentalRate, Integer length, Set<Actor> actors, Set<Category> categories, BigDecimal replacementCost) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.language = language;
        this.rentalDuration = rentalDuration;

        this.rentalRate = rentalRate;
        this.length = length;
        this.actors = actors;
        this.categories = categories;
        this.replacementCost = replacementCost;

    }
    public  Film createFilm(){
        return  new Film(
                title,
                description,
                releaseYear,
                language,
                rentalDuration,
                rentalRate,
                length,
                actors,
                categories,
                replacementCost,
                rating,
                specialFeatures);
    }
}
