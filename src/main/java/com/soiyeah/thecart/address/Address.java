package com.soiyeah.thecart.address;

import lombok.*;

import javax.persistence.*;

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

    // Constructor without ID
    public Address(String aptNo, String street, String city, String postalCode) {
        this.aptNo = aptNo;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }
}
