package com.example.java;

import com.example.java.model.ClothingItem;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Array of primitives");
        int[] ints = {3, 6, 9};
        for (int anInt : ints) {
            System.out.println(anInt);
        }

        System.out.println("Array of strings");
        String[] colors = {"Red", "Green", "Blue"};
        for (String color:
                colors) {
            System.out.println(color);
        }

        ClothingItem[] items = new ClothingItem[3];
        items[0] = new ClothingItem("Shirt", "L", 15);
        items[1] = new ClothingItem("Pants", "32", 20);
        items[2] = new ClothingItem("Hat", "M", 8);

        for (ClothingItem item :
                items) {
            System.out.println(item);
        }

        ClothingItem[] copied = Arrays.copyOf(items, items.length);
        for (ClothingItem item:
             copied) {
            System.out.println(item);
        }

        items[0].setPrice(5);
        System.out.println(items[0]);
        System.out.println(copied[0]);

    }
}
