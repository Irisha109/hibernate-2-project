package com.javarush.panova.repository;

import com.javarush.panova.entities.*;
import com.javarush.panova.repository.factory.SessionFactoryIns;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class RentalRepo {


    public static Rental getRentalByCustomerAndInventory(Customer customer, Inventory inventory){

        String hql = "from Rental r where customer = :CUSTOMER and inventory = :INVENTORY";
        try(Session session = SessionFactoryIns.getSessionFactory().openSession()){
            Query<Rental> query = session.createQuery(hql, Rental.class);
            query.setParameter("CUSTOMER", customer);
            query.setParameter("INVENTORY", inventory);

            return query.getSingleResult();
        }
    }


}
