package com.example.api.dto;

import com.example.api.domain.Address;

public class AddressDTO {

    private Long id;
    private String zipCode;
    private String street;
    private String number;
    private String city;
    private String state;
    private String country;

    public AddressDTO(Long id, String zipCode, String street, String number, String city, String state, String country) {
        this.id = id;
        this.zipCode = zipCode;
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public static AddressDTO toDTO(Address address) {
        return new AddressDTO(
                address.getId(),
                address.getZipCode(),
                address.getStreet(),
                address.getNumber(),
                address.getCity(),
                address.getState(),
                address.getCountry()
        );
    }

    public Address toEntity() {
        return new Address(
                getId(),
                getZipCode(),
                getStreet(),
                getNumber(),
                getCity(),
                getState(),
                getCountry()
        );
    }
}
