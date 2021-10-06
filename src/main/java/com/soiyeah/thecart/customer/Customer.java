package com.soiyeah.thecart.customer;

import com.soiyeah.thecart.address.Address;
import lombok.*;
import javax.persistence.*;
import java.util.List;

/** Entity class */

@Entity
@Table
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

    // Constructor without ID
    public Customer(String name, String email, String phone, Address address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.addresses.add(address);
    }

}
