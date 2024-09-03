package com.javarush.panova.repository;

import com.javarush.panova.entities.City;

import com.javarush.panova.repository.factory.SessionFactoryIns;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CityRepo {
    public static City getCityByName(String name){

        String hql = "select c from City c where c.city = :cityName";
        try(Session session = SessionFactoryIns.getSessionFactory().openSession()){
            Query<City> query = session.createQuery(hql, City.class);
            query.setParameter("cityName", name);
            return  query.getSingleResult();

        }


    }
    public static City getCityById(Integer cityId){

        String hql = "from City c where c.id = :cityId";
        try(Session session = SessionFactoryIns.getSessionFactory().openSession()){
            Query<City> query = session.createQuery(hql, City.class);
            query.setParameter("id", cityId);
            City city = query.getSingleResult();
            return  city;

        }


    }

}
