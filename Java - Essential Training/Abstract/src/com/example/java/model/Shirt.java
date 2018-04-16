package com.example.java.model;

public class Shirt extends ClothingItem {
    public Shirt(String size, double price) {
        super("Shirt", size, price);
    }

    private String pattern = "Not set";

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public double getPrice() {
        return 22.95;
    }
}
