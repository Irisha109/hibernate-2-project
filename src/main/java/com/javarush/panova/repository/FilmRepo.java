package com.javarush.panova.repository;

import com.javarush.panova.entities.Film;
import com.javarush.panova.repository.factory.SessionFactoryIns;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class FilmRepo {
    public static Film getFirstAvailableFilmForRent(){
        String hql = "from Film f where f.id not in " +
                "(select distinct film.id from Inventory)";
        try(Session session = SessionFactoryIns.getSessionFactory().openSession()){
        Query<Film> query = session.createQuery(hql, Film.class);
        query.setMaxResults(1);
        return query.getSingleResult();
        }
    }
    public static void addFilm(Film film){
        try(Session session = SessionFactoryIns.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(film);
            session.getTransaction().commit();
        }

    }
}
