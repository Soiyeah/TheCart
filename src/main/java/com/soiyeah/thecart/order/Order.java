package com.soiyeah.thecart.order;

import com.soiyeah.thecart.customer.Customer;
import com.soiyeah.thecart.orderItem.OrderItem;
import com.soiyeah.thecart.payment.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
