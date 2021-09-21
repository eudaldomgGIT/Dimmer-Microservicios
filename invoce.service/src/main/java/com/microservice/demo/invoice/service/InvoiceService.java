package com.microservice.demo.invoice.service;

import com.microservice.demo.invoice.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    public List<Invoice> findInvoiceAll();
    public Invoice getInvoice(Long id);
}
