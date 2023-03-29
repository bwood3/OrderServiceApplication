package edu.iu2.demo.model.variables;
import edu.iu2.demo.model.variables.BillingAddress;

public class Payment {

    private String method;
    private int number;
    private BillingAddress billingAddress;

    public Payment(String method, int number, BillingAddress billingAddress) {
        this.method = method;
        this.number = number;
        this.billingAddress = billingAddress;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }
}
