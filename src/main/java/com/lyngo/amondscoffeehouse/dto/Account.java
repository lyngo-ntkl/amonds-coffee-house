package com.lyngo.amondscoffeehouse.dto;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(name="accountId")
    // annotation for primary key
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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Account account = (Account) o;
//        return status == account.status && accountId.equals(account.accountId) && email.equals(account.email) && Objects.equals(password, account.password) && Objects.equals(username, account.username) && Objects.equals(roleId, account.roleId) && Objects.equals(phone, account.phone);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(accountId, email, password, username, roleId, phone, status);
//    }

    @OneToMany(mappedBy = "account")
    // one-to-many association
    // mappedBy indicates that it would be mapped by account property in contact class
    // if we don't have mappedBy, it will create new table to map
    private Set<Contact> contacts = new HashSet<>();
}
