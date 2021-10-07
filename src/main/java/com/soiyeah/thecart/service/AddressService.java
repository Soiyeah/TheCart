package com.soiyeah.thecart.service;

import com.soiyeah.thecart.model.Address;
import com.soiyeah.thecart.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    // Constructor
    @Autowired
    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }


    public Address addAddress(Address address){
        return addressRepository.save(address);
    }

    public Address getAddress(Long id){
        return addressRepository.findById(id).orElseThrow();
    }

    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

    public Address deleteAddress(Long id){
        Address address = getAddress(id);
        addressRepository.delete(address);
        return address;
    }

}
