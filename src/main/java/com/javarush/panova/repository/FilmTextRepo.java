package com.javarush.panova.repository;

import com.javarush.panova.entities.Film;
import com.javarush.panova.entities.FilmText;
import com.javarush.panova.repository.factory.SessionFactoryIns;
import org.hibernate.Session;

public class FilmTextRepo {
    public static void addFilmText(FilmText filmText){
        try(Session session = SessionFactoryIns.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(filmText);
            session.getTransaction().commit();
        }

    }
}
