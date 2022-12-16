package com.lyngo.amondscoffeehouse.dto;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
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
@EqualsAndHashCode
public class Order implements Serializable {
    public static final long serialVersionUID = 123456987;

    @Id
    @Column(name = "orderId")
    private String orderId;
    @Column(name = "status")
    private String status;
    @Column(name = "orderDate")
    private Timestamp orderDate;
    @Column(name = "shipDate")
    private Timestamp shipDate;
    @Column(name = "deliveryCharge")
    private BigDecimal deliveryCharge;
    @Column(name = "total")
    private BigDecimal total;

    public Order(String orderId, String status, Timestamp orderDate, Timestamp shipDate, BigDecimal deliveryCharge, BigDecimal total) {
        this.orderId = orderId;
        this.status = status;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.deliveryCharge = deliveryCharge;
        this.total = total;
    }

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails = new HashSet<>();
    @ManyToOne
    private Contact contact;
}
