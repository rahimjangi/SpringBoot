package com.raiseup.JDBC_API.service;

import com.raiseup.JDBC_API.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final JdbcTemplate template;


    public Customer getCustomerByFirstName(String firstName) {
        Customer customer = template.query(
                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[]{firstName},
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
        ).get(0);
        return customer;
    }

    public List<Customer> getCustomers() {
        return template.query(
                "SELECT id, first_name, last_name FROM customers",
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
        );
    }

    public void deleteCustomer(Long id) {
        template.update("delete from customers where id=?", Long.valueOf(id));
    }

    public void save(Customer customer) {
        template.update("INSERT INTO customers(first_name, last_name) VALUES (?,?)",customer.getFirstName(),customer.getLastName());
    }
}
