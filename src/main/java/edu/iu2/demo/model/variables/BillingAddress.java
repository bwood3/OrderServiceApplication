package edu.iu2.demo.model.variables;

//todo update to protected
public class BillingAddress {
    private String state;
    private String city;
    private int postalCode;

    public BillingAddress(String state, String city, int postalCode) {
        this.state = state;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}
