package com.lyngo.amondscoffeehouse.dto;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tblOrderDetails")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetail {
    @Id
    private String detailId;
    @Column(name = "productId")
    private int productId;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "total")
    private BigDecimal total;

    @ManyToOne
    private Order order;
    @ManyToOne
    private Product product;
}
