package com.example.api.service;

import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> findAll() {
        return repository.findAllByOrderByNameAsc();
    }

    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Customer save(Customer customer) {
        return repository.saveAndFlush(customer);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
