package com.example.java;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> states = new ArrayList<>();
        states.add("California");
        states.add("Oregon");
        states.add("Washington");
        for (String state :
                states) {
            System.out.println(state);
        }

        List<Integer> ints = new ArrayList<>();
        ints.add(23);
        ints.add(12);
        ints.add(54);
        for (Integer anInt :
                ints) {
            System.out.println(anInt);
        }

        states.remove(1);
        for (String state :
                states) {
            System.out.println(state);
        }

        String state = states.get(1);
        System.out.println("The second state is " + state);

        int pos = states.indexOf("Washington");
        System.out.println("Washington is at position " + pos);

    }
}
