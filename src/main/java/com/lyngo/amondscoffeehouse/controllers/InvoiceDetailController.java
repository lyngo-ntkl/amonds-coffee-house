package com.lyngo.amondscoffeehouse.controllers;

import com.lyngo.amondscoffeehouse.services.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/invoice-details")
public class InvoiceDetailController {
    @Autowired
    private InvoiceDetailService invoiceDetailService;
}
