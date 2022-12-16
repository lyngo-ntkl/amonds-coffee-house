package com.lyngo.amondscoffeehouse.dto;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tblCategories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Category implements Serializable {
    public static final long serialVersionUID = 231456789;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private int categoryId;
    @Column(name = "categoryName")
    private String categoryName;

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    @OneToMany(mappedBy = "category")
    private Set<Product> products = new HashSet<>();
}
