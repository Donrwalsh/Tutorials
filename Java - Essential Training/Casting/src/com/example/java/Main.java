package com.example.java;

import com.example.java.model.ClothingItem;
import com.example.java.model.Shirt;

public class Main {

    public static void main(String[] args) {
	// write your code here

        ClothingItem item = new ClothingItem("Shirt", "L", 19.99);
        System.out.println(item);

        Shirt shirt = new Shirt("M", 14.99);
        System.out.println(shirt);
        shirt.setPattern("Plaid");
        System.out.println("This shirt's pattern is " + shirt.getPattern());

        ClothingItem reallyAShirt = new Shirt("L", 12.99);
        System.out.println(reallyAShirt);

        Shirt shirt2 = (Shirt) reallyAShirt;
        shirt2.setPattern("Solid");
        System.out.println(reallyAShirt);
    }
}
