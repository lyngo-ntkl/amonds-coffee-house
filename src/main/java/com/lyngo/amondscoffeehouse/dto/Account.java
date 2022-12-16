package com.lyngo.amondscoffeehouse.dto;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
// identify class as entity class
@Table(name = "tblAccounts")
// map with table in database
@NoArgsConstructor
// generate no arguments constructor
@AllArgsConstructor
// generate all arguments constructor
@Getter
// generate getter
@Setter
// generate setter
@ToString
// generate ToString()
@EqualsAndHashCode
public class Account implements Serializable {
    public static final long serialVersionUID = 123456789;
    public static final String ROLEID_ADMIN = "AD";
    public static final String ROLEID_USER = "US";

    @Id
    // annotation for primary key
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    //Generate UUID
    private String accountId;
    @Column(name = "email", unique = true)
    // annotation for mapping properties to column in database
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "username")
    private String username;
    @Column(name = "roleId")
    private String roleId;
    @Column(name = "phone")
    private String phone;
    @Column(name = "status")
    private boolean status;

    public Account(String accountId, String email, String password, String username, String roleId, String phone, boolean status) {
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.username = username;
        this.roleId = roleId;
        this.phone = phone;
        this.status = status;
    }

    public Account(String email, String password, String username, String roleId, String phone, boolean status) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.roleId = roleId;
        this.phone = phone;
        this.status = status;
    }

    @OneToMany(mappedBy = "account")
    // one-to-many association
    // mappedBy indicates that it would be mapped by account property in contact class
    // if we don't have mappedBy, it will create new table to map
    private Set<Contact> contacts = new HashSet<>();
}
