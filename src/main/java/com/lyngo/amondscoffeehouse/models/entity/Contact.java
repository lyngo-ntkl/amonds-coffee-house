package com.lyngo.amondscoffeehouse.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Table(name = "contacts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private String id;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "province")
    private String province;
    @Column(name = "district")
    private String district;
    @Column(name = "ward")
    private String ward;
    @Column(name = "default_status")
    private boolean defaultStatus;

    @ManyToOne
    private Account account;
    @OneToMany(mappedBy = "contact")
    private List<Invoice> invoices;
}