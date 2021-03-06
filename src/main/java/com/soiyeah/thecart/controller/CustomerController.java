package com.soiyeah.thecart.controller;

import com.soiyeah.thecart.model.dto.CustomerDto;
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
@CrossOrigin("*")
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
    public ResponseEntity<List<CustomerDto>> getCustomers(){
        List<Customer> customers = customerService.getCustomers();
        List<CustomerDto> customersDto = customers.stream().map(CustomerDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(customersDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable final Long id){
        Customer customer = customerService.getCustomer(id);
        return new ResponseEntity<>(CustomerDto.from(customer),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto){
        Customer customer = customerService.addCustomer(Customer.from(customerDto));
        return new ResponseEntity<>(CustomerDto.from(customer), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable final Long id){
        Customer customer = customerService.deleteCustomer(id);
        return new ResponseEntity<>(CustomerDto.from(customer), HttpStatus.OK);
    }

    @PostMapping(value = "{customerId}/addresses/{addressId}/add")
    public ResponseEntity<CustomerDto> addAddressToCustomer(@PathVariable final Long customerId,
                                                            @PathVariable final Long addressId){
        Customer customer = customerService.addAddressToCustomer(customerId, addressId);
        return new ResponseEntity<>(CustomerDto.from(customer),HttpStatus.OK);
    }

}
