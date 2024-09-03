package com.javarush.panova.repository;

import com.javarush.panova.entities.City;
import com.javarush.panova.entities.Customer;
import com.javarush.panova.repository.factory.SessionFactoryIns;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CustomerRepo {

    public static void addCustomer(Customer customer){

        try(Session session = SessionFactoryIns.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(customer);
            transaction.commit();

        }
    }

    public static Customer getCustomerById(Integer customerId){

        String hql = "from Customer c where c.id = :customerId";
        try(Session session = SessionFactoryIns.getSessionFactory().openSession()){
            Query<Customer> query = session.createQuery(hql, Customer.class);
            query.setParameter("customerId", customerId);
            Customer customer = query.getSingleResult();
            return  customer;

        }


    }
}
