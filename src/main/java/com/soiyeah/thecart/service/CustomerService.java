package com.soiyeah.thecart.service;

import com.soiyeah.thecart.repository.CustomerRepository;
import com.soiyeah.thecart.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

/** Implementation of API */

@Service
public class CustomerService {

    private static final Logger LOGGER = Logger.getLogger(CustomerService.class.getName());
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        LOGGER.info("customer: "+ customer.getName());
        return customerRepository.save(customer);
    }
}
