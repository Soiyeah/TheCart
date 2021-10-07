package com.soiyeah.thecart.controller;

import com.soiyeah.thecart.model.dto.CustomerDTO;
import com.soiyeah.thecart.service.CustomerService;
import com.soiyeah.thecart.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<CustomerDTO>> getCustomers(){
        List<Customer> customers = customerService.getCustomers();
        List<CustomerDTO> customersDto = customers.stream().map(CustomerDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(customersDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDto){
        Customer customer = customerService.addCustomer(Customer.from(customerDto));
        return new ResponseEntity<>(CustomerDTO.from(customer), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable final long id){
        Customer customer = customerService.deleteCustomer(id);
        return new ResponseEntity<>(CustomerDTO.from(customer), HttpStatus.OK);
    }

}
