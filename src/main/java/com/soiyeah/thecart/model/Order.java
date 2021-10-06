package com.soiyeah.thecart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private Date date;
//    @OneToOne(cascade = CascadeType.ALL)
//    private Customer customer;
//    @OneToMany
//    private List<OrderItem> orderItems;
//    @OneToOne
//    private Payment payment;

}
