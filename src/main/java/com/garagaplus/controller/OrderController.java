package com.garagaplus.controller;

import com.garagaplus.Database.CustomerDatabase;
import com.garagaplus.Database.OrderDatabase;
import com.garagaplus.model.Order;
import com.garagaplus.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderDatabase orderDatabase;
    @Autowired
    CustomerDatabase customerDatabase;

    @GetMapping("/orders")
    List<Order> getAllOrders()
    {
        return orderDatabase.getAllOrders();
    }
    @GetMapping("/orders/{id}")
    Order getOrderByID(@PathVariable Long id)
    {
        if(orderDatabase.isOrderValid(id))
            return orderDatabase.getOrderById(id);
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Order ID Provided.");
    }
    @PostMapping("/orders")
    void addOrder(@RequestBody Order order)
    {
        if(order.getOrder_ID()==null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Order ID Not Provided.");
        if(order.getOrder_Customer_ID()==null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Customer ID Not Provided.");
        if(!customerDatabase.isCustomerValid(order.getOrder_Customer_ID()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Customer ID Provided.");
        if(order.getOrder_Total()==null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Order Total Not Provided.");
        if(order.getOrder_Total()<0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Negative Order Total Provided.");

        if(orderDatabase.getOrdersByCustomerID(order.getOrder_Customer_ID()).size()==9) {
            EmailService.sendEmail("Just 1 More Order For Gold Segment");
        }
        if(orderDatabase.getOrdersByCustomerID(order.getOrder_Customer_ID()).size()==19) {
            EmailService.sendEmail("Just 1 More Order For Platinum Segment");
        }

        if(customerDatabase.getCustomerByID(order.getOrder_Customer_ID()).getCustomer_Segment().equals("Gold"))
        {
            customerDatabase.getCustomerByID(order.getOrder_Customer_ID()).addDiscount(order.getOrder_Total()/10);
        }
        if(customerDatabase.getCustomerByID(order.getOrder_Customer_ID()).getCustomer_Segment().equals("Platinum"))
        {
            customerDatabase.getCustomerByID(order.getOrder_Customer_ID()).addDiscount(order.getOrder_Total()/20);
        }
        orderDatabase.addOrder(order.getOrder_ID(), order);
        if(orderDatabase.getOrdersByCustomerID(order.getOrder_Customer_ID()).size()==10) {
            customerDatabase.getCustomerByID(order.getOrder_Customer_ID()).setCustomer_Segment("Gold");
            EmailService.sendEmail("You Just Got Gold Segment");
        }
        if(orderDatabase.getOrdersByCustomerID(order.getOrder_Customer_ID()).size()==20) {
            customerDatabase.getCustomerByID(order.getOrder_Customer_ID()).setCustomer_Segment("Platinum");
            EmailService.sendEmail("You Just Got Platinum Segment");
        }

    }

}
