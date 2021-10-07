package com.soiyeah.thecart.model.dto;

import com.soiyeah.thecart.model.Address;
import com.soiyeah.thecart.model.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CustomerDto {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private List<AddressDto> addressesDto = new ArrayList<>();

    public static CustomerDto from(Customer customer){
        CustomerDto customerDTO = new CustomerDto();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setAddressesDto(customer.getAddresses().stream().map(AddressDto::from).collect(Collectors.toList()));
        return customerDTO;
    }

}
