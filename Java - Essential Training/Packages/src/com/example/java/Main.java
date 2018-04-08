package com.example.java;

import com.example.java.utilities.InputHelper;

public class Main {

    public static void main(String[] args) {

        String input = InputHelper.getInput("Enter value 1: ");
        System.out.println("You entered: " + input);
        input = InputHelper.getInput("Enter value 2: ");
        System.out.println("You entered: " + input);
    }

}