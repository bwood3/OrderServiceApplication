package edu.iu2.demo.model;
import edu.iu2.demo.model.variables.Item;
import edu.iu2.demo.model.variables.Payment;
import edu.iu2.demo.model.variables.ShippingAddress;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int customerID;
    private double total;
    private ShippingAddress shippingAddress;
    private Payment payment;
    private List<Item> items;

    public Order(int customerID, double total, ShippingAddress shippingAddress, Payment payment) {
        this.customerID = customerID;
        this.total = total;
        this.shippingAddress = shippingAddress;
        this.payment = payment;
        this.items = new ArrayList<>();
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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
}
