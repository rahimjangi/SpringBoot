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

    @GetMapping("/")
    public ResponseEntity<List<Customer>> getCustomers(){
        List<Customer> customers=customerService.getCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String firstName){
        Customer customer=customerService.getCustomerByFirstName(firstName);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity saveCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer>deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
}
