package com.soiyeah.thecart.controller;

import com.soiyeah.thecart.model.dto.AddressDTO;
import com.soiyeah.thecart.model.Address;
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

    @GetMapping
    public ResponseEntity<List<AddressDTO>> getAddresses(){
        List<Address> addresses = addressService.getAddresses();
        List<AddressDTO> addressesDto = addresses.stream().map(AddressDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(addressesDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AddressDTO> addAddress(@RequestBody AddressDTO addressDTO){
        Address address = addressService.addAddress(Address.from(addressDTO));
        return new ResponseEntity<>(AddressDTO.from(address), HttpStatus.OK);
    }
}
