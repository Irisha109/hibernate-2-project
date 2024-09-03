package com.javarush.panova;

import com.javarush.panova.entities.*;
import com.javarush.panova.entities.util.Feature;
import com.javarush.panova.entities.util.Rating;
import com.javarush.panova.repository.*;
import com.javarush.panova.repository.creator.*;
import com.javarush.panova.repository.factory.SessionFactoryIns;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


public class App {
    public static void main(String[] args) {
        //createAndAddCustomer();
        // Inventory inventory = InventoryRepo.getInventoryById(2408);
        //  Customer customer = CustomerRepo.getCustomerById(600);
        //  customerRentalInventory(customer);
        // customerReturnInventory(customer, inventory);
        newFilmForRental();



    }
    public static void newFilmForRental(){
        String title = "Beautiful life-2";
        String description = "It's a good film";
        Integer year = 2024;
        Language language = LanguageRepo.getLanguageById((short)1);
        Short rentalDuration = 0;
        BigDecimal rentalRate = new BigDecimal("0.0");
        Integer length = 92;
        Set<Actor> actors = ActorRepo.getActorSet(2, 15);
        Set<Category> categories = CategoryRepo.getCategorySet(4, 6);
        BigDecimal replacementCost = new BigDecimal(45);
        Rating rating = Rating.G;
        Set<Feature> features = new HashSet<>();
               features.add(Feature.TRAILERS) ;


        Film film = new FilmCreator(
                title, description, year, language,
                rentalDuration,rentalRate, length,
                actors, categories, replacementCost, rating,
                features
                ).createFilm() ;
        FilmRepo.addFilm(film);
        FilmText filmText = new FilmTextCreator(film, title, description).createFilmText();
        FilmTextRepo.addFilmText(filmText);


    }
    private static void customerRentalInventory(Customer customer){
        Film film = FilmRepo.getFirstAvailableFilmForRent();
        Store store = StoreRepo.getStoreById((short) 1);
        Inventory inventory = new InventoryCreator(film, store).createInventory();
        Staff staff = store.getManagerStaff();
        Rental rental = new RentalCreator(inventory, customer, staff).createRental();
        Payment payment = new PaymentCreator(customer, staff, rental, new BigDecimal(3.45)).createPayment();
        try(Session session = SessionFactoryIns.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(inventory);
            session.save(rental);
            session.save(payment);
            session.getTransaction().commit();
        }
    }

    private static void customerReturnInventory(Customer customer, Inventory inventory) {
        try(Session session = SessionFactoryIns.getSessionFactory().openSession()){
            session.beginTransaction();
            Rental rental = RentalRepo.getRentalByCustomerAndInventory(customer, inventory);
            rental.setReturnDate(LocalDateTime.now());
            session.update(rental);
            session.getTransaction().commit();
        }
    }

    private static void createAndAddCustomer() {
        Store store = StoreRepo.getStoreById((short) 1);
        Address address = new AddressCreator(
                "85 Workhaven Lane",
                "Alberta",
                "Akron",
                "6566645789")
                .createAddress();

        Customer customer = new CustomerCreator(
                store,
                "Lucas",
                "Smit",
                address,
                true)
                .createCustomer();

        CustomerRepo.addCustomer(customer);
    }
}
