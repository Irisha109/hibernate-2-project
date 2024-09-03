package com.javarush.panova.repository.creator;

import com.javarush.panova.entities.Film;
import com.javarush.panova.entities.Inventory;
import com.javarush.panova.entities.Store;

public class InventoryCreator {
    private Film film;
    private Store store;

    public InventoryCreator(Film film, Store store) {
        this.film = film;
        this.store = store;
    }
    public Inventory createInventory(){
        return new Inventory(film, store);
    }
}
