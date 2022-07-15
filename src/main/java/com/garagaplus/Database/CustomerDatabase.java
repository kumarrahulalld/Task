package com.garagaplus.Database;

import com.garagaplus.model.Customer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class CustomerDatabase {

    private Map<Long, Customer> customer_Table=new HashMap<>();

    public CustomerDatabase()
    {

    }

    public void addCustomer(Long customer_ID,Customer customer)
    {
            customer_Table.put(customer_ID,customer);
    }
    public void removeCustomer(Long customer_ID)
    {
        customer_Table.remove(customer_ID);
    }
    public boolean isCustomerValid(Long customer_ID)
    {
        return customer_Table.containsKey(customer_ID);
    }
    public List<Customer> getAllCustomers()
    {
        return customer_Table.values().stream().toList();
    }
    public Customer getCustomerByID(Long customer_ID)
    {
        return customer_Table.get(customer_ID);
    }
    public List<Customer> getCustomersBySegment(String customer_Segment)
    {
        return customer_Table.values().stream().filter(customer -> customer.getCustomer_Segment().equals(customer_Segment)).toList();
    }



}

