package edu.iu2.demo.repository;
import edu.iu2.demo.model.Order;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private List<Order> orders = new ArrayList<>();

    //to create new orders from order controller
    public int create(Order order)
    {
        orders.add(order);
        return order.getId();
    }

    //if order id does not exist create one
    public void update (Order order, int id)
    {
        Order o = getOrderByID(id);
        if(o != null)
        {
            o.setId(id);
            o.setTotal(order.getTotal());
            o.setShippingAddress(o.getShippingAddress());
            o.setItems(o.getItems());
            o.setPayment(o.getPayment());
        }
        //todo add exception handler class
        //id not found case
        else {
            throw new IllegalStateException("customer id is not valid.");
        }
    }

    //find order by customer ID
    public Order getOrderByID(int id)
    {
        return orders.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }

    public List<Order> getAllOrders()
    {
        return orders;
    }

    //TODO FINISH
}
