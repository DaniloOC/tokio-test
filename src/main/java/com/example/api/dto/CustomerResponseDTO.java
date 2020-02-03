package com.example.api.dto;

import com.example.api.domain.Address;
import com.example.api.domain.Customer;

import java.util.Set;
import java.util.stream.Collectors;

public class CustomerResponseDTO {
    private Long id;
    private String name;
    private String email;
    private Set<AddressDTO> addresses;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Set<AddressDTO> getAddresses() {
        return addresses;
    }

    public CustomerResponseDTO(Long id, String name, String email, Set<Address> addresses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.addresses = addresses.stream().map(AddressDTO::toDTO).collect(Collectors.toSet());
    }

    public static CustomerResponseDTO toDTO(Customer customer) {
        return new CustomerResponseDTO(customer.getId(), customer.getName(), customer.getEmail(), customer.getAddresses());
    }
}
