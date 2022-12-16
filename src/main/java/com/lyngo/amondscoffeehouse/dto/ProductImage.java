package com.lyngo.amondscoffeehouse.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "tblProductImages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage implements Serializable {
    public static final long serialVersionUID = 20000915;

    @Id
    @Column(name = "imgPath")
    private String imgPath;

    public ProductImage(String imgPath) {
        this.imgPath = imgPath;
    }

    @ManyToOne
    private Product product;
}
