package com.microservice.demo.customer.cutomerservice.controller;

import com.microservice.demo.customer.cutomerservice.entity.Customer;
import com.microservice.demo.customer.cutomerservice.entity.Region;
import com.microservice.demo.customer.cutomerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customers")
public class CustomerRest {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> listAllCustomers(@RequestParam(name = "regionId", required = false)
                                                                       Long regionId){
        List<Customer> customers = new ArrayList<>();
        if(regionId == null)
            customers = customerService.findCustomerAll();
        else{
            Region region = new Region();
            region.setId(regionId);
            customers = customerService.findCustomerByRegion(region);
        }
        if(customers == null){
            log.error("Customers with Region id {} not found", regionId);
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customers);
    }
}
