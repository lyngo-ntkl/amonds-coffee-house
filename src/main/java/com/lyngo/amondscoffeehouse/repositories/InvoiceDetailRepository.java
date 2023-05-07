package com.lyngo.amondscoffeehouse.repositories;

import com.lyngo.amondscoffeehouse.models.entity.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, String> {
}
