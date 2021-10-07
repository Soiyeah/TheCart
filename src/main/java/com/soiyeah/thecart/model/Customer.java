package com.soiyeah.thecart.model;

import com.soiyeah.thecart.model.dto.CustomerDTO;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/** Entity class */

@Entity
@Table(name = "Customer")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<Address> addresses = new ArrayList<>();

    // Constructor without ID
    public Customer(String name, String email, String phone, Address address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.addresses.add(address);
    }

    // Assign an address to the customer
    public void addAddress(Address address){
        addresses.add(address);
    }

    // Remove assigned address from customer
    public void removeAddress(Address address){
        addresses.remove(address);
    }

    // DTO Transformer
    public static Customer from(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        return customer;
    }

}
