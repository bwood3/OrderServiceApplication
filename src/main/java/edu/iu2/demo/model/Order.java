package edu.iu2.demo.model;
import edu.iu2.demo.model.orderFields.Item;
import edu.iu2.demo.model.orderFields.Payment;
import edu.iu2.demo.model.orderFields.ShippingAddress;

import java.util.List;
import java.util.Objects;
//NOTE: JSON dictionary keys should match get and set in Order exactly (except for first capital letter)-
//-retrieving is done automatically
//NOTE: any "getter" here will print when order is returned
public class Order {

    private int id;
    private double total;
    private ShippingAddress shippingAddress;
    private Payment payment;
    private List<Item> items;

    public int getOrderId() {
        return id;
    }

    public void setOrderId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {

        if(shippingAddress.getCity().isEmpty())
        {
            throw new IllegalStateException("Shipping city must not be blank.");
        }
        if(shippingAddress.getState().isEmpty())
        {
            throw new IllegalStateException("Shipping state must not be blank.");
        }
        this.shippingAddress = shippingAddress;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Item> getItems() {
        return items;
    }

    //find used so because spring auto prints getters
    public Item findItemsByID(int id)
    {
        return this.items.stream().filter(x -> x.getItemId() == id).findAny().orElse(null);
    }

    public void setItems(List<Item> items) {
        //Add validation criteria
        for(Item i : items)
            if(i.getName().isEmpty())
                throw new IllegalStateException("Customer item name must not be blank.");

        this.items = items;
    }

    //hash code to compare order objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order customer = (Order) o;
        return id == customer.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
