package com.example.learing.sync.DTO;


public class Order   {

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    private int productId;
    private String name;
    private String productType;
    private int qty;
    private double price;

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    private String trackingId;
}