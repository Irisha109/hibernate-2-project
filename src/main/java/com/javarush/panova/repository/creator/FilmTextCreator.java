package com.javarush.panova.repository.creator;

import com.javarush.panova.entities.Film;
import com.javarush.panova.entities.FilmText;

public class FilmTextCreator {
    private Film film;
    private String title;
    private String description;

    public FilmTextCreator(Film film, String title, String description) {
        this.film = film;
        this.title = title;
        this.description = description;
    }
    public FilmText createFilmText(){
        return  new FilmText(film.getId(), title, description);
    }
}
