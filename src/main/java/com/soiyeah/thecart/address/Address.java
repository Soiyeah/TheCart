package com.soiyeah.thecart.address;

import lombok.*;
import javax.persistence.*;

import com.soiyeah.thecart.customer.Customer;

/** Entity class*/

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String aptNo;
    private String street;
    private String city;
    private String postalCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    // Constructor without ID
    public Address(String aptNo, String street, String city, String postalCode, Customer customer) {
        this.aptNo = aptNo;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.customer = customer;
    }
}
