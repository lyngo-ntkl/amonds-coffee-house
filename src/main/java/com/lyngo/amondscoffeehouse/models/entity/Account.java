package com.lyngo.amondscoffeehouse.models.entity;

import com.lyngo.amondscoffeehouse.common.enums.AccountRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id;

    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "username")
    private String username;
    @Column(name = "role")
    private AccountRole role;
    @Column(name = "blocked_status")
    private boolean blockedStatus; // false: blocked account

    @OneToMany(mappedBy = "account")
    private List<Contact> contacts;
}
