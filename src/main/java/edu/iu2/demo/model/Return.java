package edu.iu2.demo.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Return {

    //map holding order id [item id, reason for return]
    private int orderId;
    private int itemId;
    private String reason;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
