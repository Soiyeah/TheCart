package com.soiyeah.thecart.controller;

import com.soiyeah.thecart.service.CustomerService;
import com.soiyeah.thecart.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/** Contains the API */

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    private static final Logger LOGGER = Logger.getLogger(Customer.class.getName());
    private final CustomerService customerService;

    // Constructor
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Get list of all customers
    @GetMapping
    public List<Customer> getCustomer(){
        return customerService.getCustomer();
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }


}
