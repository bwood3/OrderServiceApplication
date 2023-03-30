package edu.iu2.demo.model;
import edu.iu2.demo.model.variables.Item;
import edu.iu2.demo.model.variables.Payment;
import edu.iu2.demo.model.variables.ShippingAddress;

import java.util.List;
import java.util.Objects;

public class Order {
    private int id;
    private double total;
    private ShippingAddress shippingAddress;
    private Payment payment;
    private List<Item> items;

//    public Order(int customerID, double total, ShippingAddress shippingAddress, Payment payment) {
//        this.customerID = customerID;
//        this.total = total;
//        this.shippingAddress = shippingAddress;
//        this.payment = payment;
//        this.items = new ArrayList<>();
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void setItems(List<Item> items) {
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
