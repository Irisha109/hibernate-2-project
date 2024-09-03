package com.javarush.panova.repository.creator;

import com.javarush.panova.entities.Address;
import com.javarush.panova.entities.City;
import com.javarush.panova.repository.CityRepo;

public class AddressCreator {
    private Address fullAddress;
    private String address;
    private String district;
    private String cityName;

    private String phone;
    private CityRepo cityRepo;

    public AddressCreator(String address, String district, String cityName, String phone) {
        this.address = address;
        this.district = district;
        this.cityName = cityName;
        this.phone = phone;

    }

    public Address createAddress() {
        City city = CityRepo.getCityByName(cityName);
        fullAddress = new Address(address, district, city, phone);
        return fullAddress;
    }
}
//Alberta - district;
//Beira - city;
//85 Workhaven Lane - address;
//6566645789 - phone;