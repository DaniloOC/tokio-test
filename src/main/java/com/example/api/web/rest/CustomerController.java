package com.example.api.web.rest;

import com.example.api.domain.Customer;
import com.example.api.dto.CustomerDTO;
import com.example.api.dto.CustomerResponseDTO;
import com.example.api.exception.CustomerNotFoundException;
import com.example.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<CustomerResponseDTO> findAll() {
        return service.findAll().stream()
                .map(CustomerResponseDTO::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CustomerResponseDTO findById(@PathVariable Long id) {
        return service.findById(id)
                .map(CustomerResponseDTO::toDTO)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PostMapping
    public CustomerResponseDTO add(@RequestBody CustomerDTO customerDTO) {
        Customer customer = service.save(customerDTO.toEntity());
        return CustomerResponseDTO.toDTO(customer);
    }

    @PutMapping("/{id}")
    public CustomerResponseDTO update(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return service.findById(id).map(oldCustomer -> {
            oldCustomer.setName(customerDTO.getName());
            oldCustomer.setEmail(customerDTO.getEmail());
            Customer customer = service.save(oldCustomer);
            return CustomerResponseDTO.toDTO(customer);
        }).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Customer> customerOpt = service.findById(id);
        if (!customerOpt.isPresent()) {
            throw new CustomerNotFoundException(id);
        }
        service.deleteById(id);
    }
}
