package com.soiyeah.thecart.model.dto;

import com.soiyeah.thecart.model.Address;
import lombok.Data;

@Data
public class AddressDto {

    private long id;
    private String aptNo;
    private String street;
    private String city;
    private String postalCode;

    // Address to AddressDto transformer
    public static AddressDto from(Address address){
        AddressDto addressDTO = new AddressDto();
        addressDTO.setId(address.getId());
        addressDTO.setAptNo(address.getAptNo());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setCity(address.getCity());
        addressDTO.setPostalCode(address.getPostalCode());
        return addressDTO;
    }

}
