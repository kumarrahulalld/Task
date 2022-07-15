package com.garagaplus.model;

import org.springframework.stereotype.Component;

@Component
public class Order {
    public Long getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(Long order_ID) {
        Order_ID = order_ID;
    }

    public Long getOrder_Total() {
        return Order_Total;
    }

    public void setOrder_Total(Long order_Total) {
        Order_Total = order_Total;
    }

    public void setOrder_Customer_ID(Long order_Customer_ID) {
        Order_Customer_ID = order_Customer_ID;
    }

    public Long getOrder_Customer_ID() {
        return Order_Customer_ID;
    }

    private Long Order_ID;
    private Long Order_Total;

    private Long Order_Customer_ID;

    public Order()
    {

    }
    public Order(Long order_ID, Long order_Total,Long order_customer_ID) {
        Order_ID = order_ID;
        Order_Total = order_Total;
        Order_Customer_ID=order_customer_ID;
    }
}
