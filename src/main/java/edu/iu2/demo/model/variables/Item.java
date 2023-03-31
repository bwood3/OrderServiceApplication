package edu.iu2.demo.model.variables;

public class Item {

//    @NotEmpty(message = "Shipping Address \"state\" must not be empty")
    private String name;
    private int quantity;
    private double price;
    private int itemId;

    //if this is not empty -> itemReturn is set to true
    private String reason ="";
    private boolean itemReturn = false;

    public void requestItemReturn()
    {
        itemReturn = true;
    }

    public boolean isReturning()
    {
        return itemReturn;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }



//    public Item(String name, int quantity, double price, int itemId) {
//        this.name = name;
//        this.quantity = quantity;
//        this.price = price;
//        this.itemId = itemId;
//    }

    public void setItemId(int id)
    {
        this.itemId = id;
    }

    public int getItemId() {
        return this.itemId;
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

}
