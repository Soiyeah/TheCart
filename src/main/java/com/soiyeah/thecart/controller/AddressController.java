package com.soiyeah.thecart.controller;

import com.soiyeah.thecart.model.Customer;
import com.soiyeah.thecart.model.dto.AddressDto;
import com.soiyeah.thecart.model.Address;
import com.soiyeah.thecart.model.dto.CustomerDto;
import com.soiyeah.thecart.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AddressDto> getAddress(@PathVariable final Long id){
        Address address = addressService.getAddress(id);
        return new ResponseEntity<>(AddressDto.from(address),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> getAddresses(){
        List<Address> addresses = addressService.getAddresses();
        List<AddressDto> addressesDto = addresses.stream().map(AddressDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(addressesDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AddressDto> addAddress(@RequestBody AddressDto addressDTO){
        Address address = addressService.addAddress(Address.from(addressDTO));
        return new ResponseEntity<>(AddressDto.from(address), HttpStatus.OK);
    }


}
