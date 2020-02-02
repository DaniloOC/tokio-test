package com.example.api.dto;

import com.example.api.domain.Customer;

public class CustomerResponseDTO {
    private Long id;
    private String name;
    private String email;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public CustomerResponseDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static CustomerResponseDTO toDTO(Customer customer) {
        return new CustomerResponseDTO(customer.getId(), customer.getName(), customer.getEmail());
    }
}
