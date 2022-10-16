package com.raiseup.JDBC_API.controller;

import com.raiseup.JDBC_API.model.Customer;
import com.raiseup.JDBC_API.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer>getCustomer(@PathVariable Long id){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer>saveCustomer(@PathVariable Long id){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer>deleteCustomer(@PathVariable Long id){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
}
