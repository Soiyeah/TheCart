package com.soiyeah.thecart.dto;

import com.soiyeah.thecart.model.Address;
import lombok.Data;

@Data
public class AddressDTO {

    private long id;
    private String aptNo;
    private String street;
    private String city;
    private String postalCode;

    // Address to AddressDTO transformer
    public static AddressDTO from(Address address){
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setAptNo(address.getAptNo());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setCity(address.getCity());
        addressDTO.setPostalCode(address.getPostalCode());
        return addressDTO;
    }

}
