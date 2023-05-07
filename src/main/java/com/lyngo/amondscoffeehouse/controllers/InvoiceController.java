package com.lyngo.amondscoffeehouse.controllers;

import com.lyngo.amondscoffeehouse.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
}
