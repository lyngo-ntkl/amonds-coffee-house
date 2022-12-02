package com.lyngo.amondscoffeehouse.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tblContacts")
public class Contact{
//    public static final long serialVersionUID = 123465789;
    @Id
    private String contactId;
    @Column(name = "phone")
    private String phone;
    @Column(name = "city")
    private String city;
    @Column(name = "district")
    private String district;
    @Column(name = "ward")
    private String ward;

    @ManyToOne
    // many-to-one association
    // map column as a foreign key
    private Account account;
    @OneToMany(mappedBy = "contact")
    private Set<Order> orders = new HashSet<>();
}
