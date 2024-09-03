package com.javarush.panova.repository;

import com.javarush.panova.entities.Inventory;
import com.javarush.panova.repository.factory.SessionFactoryIns;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class InventoryRepo {
    public static Inventory getInventoryById(Integer inventoryId){

        String hql = "from Inventory i where i.id = :id";
        try(Session session = SessionFactoryIns.getSessionFactory().openSession()){
            Query<Inventory> query = session.createQuery(hql, Inventory.class);
            query.setParameter("id", inventoryId);
            Inventory inventory = query.getSingleResult();
            return  inventory;

        }


    }
}
