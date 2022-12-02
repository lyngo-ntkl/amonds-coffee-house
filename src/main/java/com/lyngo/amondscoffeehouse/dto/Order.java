package com.lyngo.amondscoffeehouse.dto;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tblOrders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order{
//    public static final long serialVersionUID = 123456987;

    @Id
    private String orderId;
    @Column(name = "accountId")
    private String accountId;
    @Column(name = "status")
    private String status;
    @Column(name = "orderDate")
    private Timestamp orderDate;
    @Column(name = "shipDate")
    private Timestamp shipDate;
    @Column(name = "total")
    private BigDecimal total;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails = new HashSet<>();
    @ManyToOne
    private Contact contact;
}
