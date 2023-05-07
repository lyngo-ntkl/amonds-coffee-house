package com.lyngo.amondscoffeehouse.services.impl;

import com.lyngo.amondscoffeehouse.repositories.ContactRepository;
import com.lyngo.amondscoffeehouse.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
}
