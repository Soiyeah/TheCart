package com.soiyeah.thecart.model.dto;

import com.soiyeah.thecart.model.Address;
import com.soiyeah.thecart.model.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CustomerDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private List<Address> addresses = new ArrayList<>();

    public static CustomerDTO from(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setAddresses(customer.getAddresses());
        return customerDTO;
    }

}
