package com.garagaplus.controller;

import com.garagaplus.Database.CustomerDatabase;
import com.garagaplus.Database.OrderDatabase;
import com.garagaplus.model.Customer;
import com.garagaplus.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerDatabase customerDatabase;
    @Autowired
    OrderDatabase orderDatabase;
    @GetMapping("/customers")
    List<Customer> getAll()
    {
        return customerDatabase.getAllCustomers();
    }
    @GetMapping("/customers/{id}")
    Customer getCustomerByID(@PathVariable Long id)
    {
        if(customerDatabase.isCustomerValid(id))
            return customerDatabase.getCustomerByID(id);
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Customer ID Provided.");

    }
    @PostMapping("/customers")
    void addCustomer(@RequestBody Customer customer)
    {
        if(customer.getCustomer_ID()==null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Customer ID Not Provided.");
        if(customer.getCustomer_Name()==null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Customer Name Not Provided.");
        customer.setCustomer_Segment("Regular");
        customerDatabase.addCustomer(customer.getCustomer_ID(),customer);
    }
    @ResponseBody
    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable Long id)
    {
        if(customerDatabase.isCustomerValid(id))
            customerDatabase.removeCustomer(id);
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Customer ID Provided.");
    }
    @GetMapping("/customers/segment/{segment}")
    List<Customer> getCustomerBySegment(@PathVariable String segment)
    {
        if(segment.equals("Regular") || segment.equals("Gold")|| segment.equals("Platinum"))
        {
            return customerDatabase.getCustomersBySegment(segment);
        }
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Segment Type Provided.");

    }
    @GetMapping("/customers/{id}/orders")
    List<Order> getOrders(@PathVariable Long id)
    {
        if(customerDatabase.isCustomerValid(id))
            return orderDatabase.getOrdersByCustomerID(id);
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Customer ID Provided.");
    }
}
