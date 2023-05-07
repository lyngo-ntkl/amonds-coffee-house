package com.lyngo.amondscoffeehouse.repositories;

import com.lyngo.amondscoffeehouse.models.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,String> {
}
