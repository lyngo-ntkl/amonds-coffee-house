package com.lyngo.amondscoffeehouse.models.entity;

import com.lyngo.amondscoffeehouse.common.enums.PaymentMethods;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "invoices")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name = "subtotal")
    private BigDecimal subtotal;
    @Column(name = "tax")
    private BigDecimal tax;
    @Column(name = "discount")
    private BigDecimal discount;
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "created_date")
    private Timestamp createdDate;
    @Column(name = "payment")
    private PaymentMethods paymentMethod;

    @ManyToOne(optional = false)
    private Contact contact;
    @OneToMany(fetch = FetchType.EAGER)
    private List<InvoiceDetail> invoiceDetails;
}
