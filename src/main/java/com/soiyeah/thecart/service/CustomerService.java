package com.soiyeah.thecart.service;

import com.soiyeah.thecart.model.Address;
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
    private  final AddressService addressService;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, AddressService addressService) {
        this.customerRepository = customerRepository;
        this.addressService = addressService;
    }


    public Customer getCustomer(Long customerId){
        return customerRepository.findById(customerId).orElseThrow();
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        LOGGER.info("customer: "+ customer.getName());
        return customerRepository.save(customer);
    }

    public Customer deleteCustomer(Long id){
        Customer customer = getCustomer(id);
        customerRepository.delete(customer);
        return customer;
    }


    public Customer addAddressToCustomer(Long customerId, Long addressId){
        Customer customer = getCustomer(customerId);
        Address address = addressService.getAddress(addressId);
        customer.addAddress(address);
        return customer;
    }

    public Customer removeAddressFromCustomer(Long customerId, Long addressId){
        Customer customer = getCustomer(customerId);
        Address address = addressService.getAddress(addressId);
        customer.removeAddress(address);
        return customer;
    }


}
