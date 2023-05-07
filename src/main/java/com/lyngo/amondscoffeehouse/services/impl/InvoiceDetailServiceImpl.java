package com.lyngo.amondscoffeehouse.services.impl;

import com.lyngo.amondscoffeehouse.repositories.InvoiceDetailRepository;
import com.lyngo.amondscoffeehouse.services.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceDetailServiceImpl implements InvoiceDetailService {

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;
}
