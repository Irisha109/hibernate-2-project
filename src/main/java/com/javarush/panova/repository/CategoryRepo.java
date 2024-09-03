package com.javarush.panova.repository;

import com.javarush.panova.entities.Actor;
import com.javarush.panova.entities.Category;
import com.javarush.panova.repository.factory.SessionFactoryIns;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CategoryRepo {
    public static Set<Category> getCategorySet(Integer offset, Integer limit){

        String hql = "from Category ";
        try(Session session = SessionFactoryIns.getSessionFactory().openSession()){
            Query<Category> query = session.createQuery(hql, Category.class);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            List<Category> categories = query.list();
            return new HashSet<>(categories);

        }


    }
}
