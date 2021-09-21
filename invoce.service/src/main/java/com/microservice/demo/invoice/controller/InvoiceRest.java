package com.microservice.demo.invoice.controller;

import com.microservice.demo.invoice.entity.Invoice;
import com.microservice.demo.invoice.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/invoices")
public class InvoiceRest {
    @Autowired
    InvoiceService invoiceService;
    @GetMapping
    public ResponseEntity<List<Invoice>>listAllInvoices(){
        List<Invoice> invoices = invoiceService.findInvoiceAll();
        if(invoices.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(invoices);
    }
}
