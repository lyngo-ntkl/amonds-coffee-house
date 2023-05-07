package com.lyngo.amondscoffeehouse.models.entity;

import com.lyngo.amondscoffeehouse.common.enums.ProductCategories;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "description")
    private String description;
    @Column(name = "category")
    private ProductCategories category;

    @OneToMany(mappedBy = "product")
    private List<InvoiceDetail> invoiceDetails;
    @OneToMany(fetch = FetchType.EAGER)
    private List<ProductImage> productImages;
}
