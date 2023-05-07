package com.lyngo.amondscoffeehouse.repositories;

import com.lyngo.amondscoffeehouse.models.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {
}
