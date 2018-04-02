package com.example.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder("Welcome");
//        sb.append(" to California!");
//        sb.toString();
//        String result = sb.toString();
//        System.out.println(result);

        StringBuilder b = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter value 1: ");
        String input1 = scanner.nextLine();

        System.out.print("Enter value 2: ");
        String input2 = scanner.nextLine();

        b.append(input1).append(", ").append(input2);
        System.out.println(b);
    }
}
