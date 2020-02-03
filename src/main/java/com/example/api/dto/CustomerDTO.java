package com.example.api.dto;

import com.example.api.domain.Address;
import com.example.api.domain.Customer;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomerDTO {

    private String name;
    private String email;
    private Set<AddressDTO> addresses = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressDTO> addresses) {
        this.addresses = addresses;
    }

    public Customer toEntity() {
        return new Customer(name, email, addresses.stream().map(AddressDTO::toEntity).collect(Collectors.toSet()));
    }

    public Collection<? extends Address> getAddressesEntity() {
        return getAddresses().stream().map(AddressDTO::toEntity).collect(Collectors.toSet());
    }
}
