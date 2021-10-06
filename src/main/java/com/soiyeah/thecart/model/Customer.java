package com.soiyeah.thecart.model;

import com.soiyeah.thecart.model.Address;
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

    public void addAddress(Address address){
        addresses.add(address);
    }


}
