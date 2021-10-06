package com.soiyeah.thecart.customer;

import com.soiyeah.thecart.address.Address;
import lombok.*;
import javax.persistence.*;

/** Entity class */

@Entity
@Table
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    @OneToOne(mappedBy = "Customer")
    private Address address;

    // Constructor without ID
    public Customer(String name, String email, String phone, Address address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

}
