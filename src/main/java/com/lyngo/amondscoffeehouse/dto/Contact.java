package com.lyngo.amondscoffeehouse.dto;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "tblContacts")
public class Contact implements Serializable {
    public static final long serialVersionUID = 123465789;
    @Id
    @Column(name = "contactId")
    private String contactId;
    @Column(name = "phone")
    private String phone;
    @Column(name = "city")
    private String city;
    @Column(name = "district")
    private String district;
    @Column(name = "ward")
    private String ward;

    public Contact(String contactId, String phone, String city, String district, String ward, Account account) {
        this.contactId = contactId;
        this.phone = phone;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.account = account;
    }

    @ManyToOne
    // many-to-one association
    // map column as a foreign key
    private Account account;
    @OneToMany(mappedBy = "contact")
    private Set<Order> orders = new HashSet<>();
}
