package edu.iu2.demo.repository;
import edu.iu2.demo.model.Order;

import edu.iu2.demo.model.Return;
import edu.iu2.demo.model.variables.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private List<Order> orders = new ArrayList<>();

    //to create new orders from order controller
    public int create(Order order)
    {
        //ensure we only have one-one id's
        if(getOrderByID(order.getOrderId()) == null)
            orders.add(order);

        return order.getOrderId();
    }

    //currently used for returns only
    public void update (Return order)
    {
        int orderId = order.getOrderId();
        Order o = getOrderByID(orderId);

        if(o != null)
        {
            Item i = o.findItemsByID(2);
            i.setReason(order.getReason());
            i.requestItemReturn();
            System.out.printf("Updating item %s (item ID:%d) because \"%s\"",i.getName(), i.getItemId(), i.getReason());
//            o.setOrderId(orderId);
//            o.setTotal(order.getTotal());
//            o.setShippingAddress(o.getShippingAddress());
//            o.setItems(o.getItems());
//            o.setPayment(o.getPayment());
        }
        //id not found case
        else {
            throw new IllegalStateException("Order id is not valid.");
        }
    }

    //find order by customer ID
    public Order getOrderByID(int id)
    {
        Order r = orders.stream().filter(x -> x.getOrderId() == id).findAny().orElse(null);
//        System.out.println(r);
        return r;
//        if(r != null)
//            return r;
//        else {
//            throw new IllegalStateException("Customer id does not exist.");
//        }
    }

    public List<Order> getAllOrders()
    {
        return orders;
    }

    public void deleteOrder(int id)
    {
        Order o = getOrderByID(id);
        if(o != null)
            orders.remove(o);
    }
}
