package com.javarush.panova.repository;

import com.javarush.panova.entities.Actor;
import com.javarush.panova.entities.Customer;
import com.javarush.panova.repository.factory.SessionFactoryIns;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ActorRepo {
    public static Set<Actor> getActorSet(Integer offset, Integer limit){

        String hql = "from Actor ";
        try(Session session = SessionFactoryIns.getSessionFactory().openSession()){
            Query<Actor> query = session.createQuery(hql, Actor.class);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
           List <Actor> actors = query.list();
           return new HashSet<>(actors);

        }


    }
}
