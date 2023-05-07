package com.lyngo.amondscoffeehouse.repositories;

import com.lyngo.amondscoffeehouse.models.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,String> {
}
