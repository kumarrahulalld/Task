package com.garagaplus.Database;

import com.garagaplus.model.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class OrderDatabase {

    private Map<Long, Order> Order_Table=new HashMap<>();

    public OrderDatabase()
    {

    }
    public boolean isOrderValid(Long order_ID)
    {
        return Order_Table.containsKey(order_ID);
    }
    public void addOrder(Long order_ID,Order order)
    {

        Order_Table.put(order_ID,order);
    }
    public Order getOrderById(Long order_ID)
    {
        return Order_Table.get(order_ID);
    }
    public void removeOrder(Long order_ID)
    {
        Order_Table.remove(order_ID);
    }
    public List<Order> getAllOrders()
    {
        return Order_Table.values().stream().toList();
    }
    public List<Order> getOrdersByCustomerID(Long customer_ID)
    {
        return Order_Table.values().stream().filter(order -> order.getOrder_Customer_ID()==customer_ID).toList();
    }


}
