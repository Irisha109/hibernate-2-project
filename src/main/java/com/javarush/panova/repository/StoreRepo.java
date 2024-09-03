package com.javarush.panova.repository;

import com.javarush.panova.entities.Store;
import com.javarush.panova.repository.factory.SessionFactoryIns;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class StoreRepo {
    public static Store getStoreById(Short id){
        Store store = null;
        try(Session session = SessionFactoryIns.getSessionFactory().openSession()){
            Query<Store> query = session.createQuery("from Store  where id = :storeId");
            query.setParameter("storeId", id);
            store = query.getSingleResult();
        } return store;
    }
}
