package com.example.api.service;

import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Page<Customer> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");
        return repository.findAll(pageRequest);
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
