package com.garagaplus.model;

import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Customer {
    public Long getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(Long customer_ID) {
        Customer_ID = customer_ID;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public String getCustomer_Segment() {
        return Customer_Segment;
    }

    public void setCustomer_Segment(String customer_Segment) {
        Customer_Segment = customer_Segment;
    }

    public Long getCustomer_Total_Discount() {
        return Customer_Total_Discount;
    }

    public void setCustomer_Total_Discount(Long customer_Total_Discount) {
        Customer_Total_Discount = customer_Total_Discount;
    }

    private Long Customer_ID;
    private String Customer_Name;
    private String Customer_Segment;
    private Long Customer_Total_Discount;

    public Customer()
    {

    }
    public void addDiscount(Long discount)
    {
        this.setCustomer_Total_Discount(this.getCustomer_Total_Discount()+discount);
    }

    public Customer(Long customer_ID, String customer_Name, String customer_Segment, Long customer_Total_Discount) {
        Customer_ID = customer_ID;
        Customer_Name = customer_Name;
        Customer_Segment = customer_Segment;
        Customer_Total_Discount = customer_Total_Discount;
    }
}
