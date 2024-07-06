package data.models;

import java.util.ArrayList;

public class Order {
    public String name;
    final String phone;
    public String address;
    public String paymentType;
    public String deliveryTime;
    public ArrayList<CartItem> cart;

    public Order(String name, String phone, String address, String paymentType, String deliveryTime, ArrayList<CartItem> cart) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.paymentType = paymentType;
        this.deliveryTime = deliveryTime;
        this.cart = cart;
    }
}
