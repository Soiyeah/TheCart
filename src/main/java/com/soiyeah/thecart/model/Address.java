package com.soiyeah.thecart.model;

import lombok.*;
import javax.persistence.*;

/** Entity class*/

@Entity
@Table(name = "Address")
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

    @ManyToOne
    private Customer customer;

    // Constructor without ID
    public Address(String aptNo, String street, String city, String postalCode) {
        this.aptNo = aptNo;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;

    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

}
