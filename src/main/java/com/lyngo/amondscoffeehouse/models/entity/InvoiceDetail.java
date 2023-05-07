package com.lyngo.amondscoffeehouse.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "invoice_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne(optional = false)
    private Invoice invoice;
    @ManyToOne(optional = false)
    private Product product;
}
