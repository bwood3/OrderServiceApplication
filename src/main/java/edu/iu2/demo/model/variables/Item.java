package edu.iu2.demo.model.variables;

public class Item {

    private String name;
    private int quantity;
    private double price;

    private final int itemId;

    public Item(String name, int quantity, double price, int itemId) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }
}
