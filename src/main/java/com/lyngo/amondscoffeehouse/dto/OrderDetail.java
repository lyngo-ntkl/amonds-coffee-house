package com.lyngo.amondscoffeehouse.dto;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "tblOrderDetails")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetail implements Serializable {
    public static final long serialVersionUID = 1503166789;

    @Id
    @Column(name = "detailId")
    private String detailId;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "discount")
    private BigDecimal discount;
    @Column(name = "total")
    private BigDecimal total;

    public OrderDetail(String detailId, BigDecimal price, int quantity, BigDecimal discount, BigDecimal total) {
        this.detailId = detailId;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.total = total;
    }

    @ManyToOne
    private Order order;
    @ManyToOne
    private Product product;
}
