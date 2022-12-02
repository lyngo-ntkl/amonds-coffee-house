package com.lyngo.amondscoffeehouse.dto;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tblProducts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
//    public static final long serialVersionUID = 123456798;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // auto-generate value for productId
    private int productId;
    @Column(name = "productName")
    private String productName;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "imgPath")
    private String imgPath;
    @Column(name = "description")
    private String description;

    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails = new HashSet<>();
}
