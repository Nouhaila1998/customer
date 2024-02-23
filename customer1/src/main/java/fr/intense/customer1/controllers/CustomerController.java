package fr.intense.customer1.controllers;

import fr.intense.customer1.entities.Customer;
import fr.intense.customer1.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    CustomerRepository customerRepository;

    //génerer le controleur automatiquement
    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable Long id) {

        return customerRepository.findById(id).orElse(null);


    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }



}
