package com.lyngo.amondscoffeehouse.dto;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
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
public class Product implements Serializable {
    public static final long serialVersionUID = 123456798;

    @Id
    @Column(name = "productId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // auto-generate value for productId
    private int productId;
    @Column(name = "productName")
    private String productName;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "description")
    private String description;

    public Product(int productId, String productName, BigDecimal price, int quantity, String description) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public Product(int productId, String productName, BigDecimal price, int quantity, String description, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "categoryId", foreignKey = @ForeignKey(name = "FK_tblProducts"))
    private Category category;
    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails = new HashSet<>();
    @OneToMany(mappedBy = "product")
    private Set<ProductImage> productImages = new HashSet<>();
}
