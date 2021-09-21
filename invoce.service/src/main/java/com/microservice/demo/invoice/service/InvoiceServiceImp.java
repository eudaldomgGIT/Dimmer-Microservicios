package com.microservice.demo.invoice.service;

import com.microservice.demo.invoice.entity.Invoice;
import com.microservice.demo.invoice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImp implements InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> findInvoiceAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoice(Long id) {
        return this.invoiceRepository.findById(id).orElse(null);
    }
}
