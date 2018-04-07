package com.example.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String s1 = getInput("Enter value 1: ");
        String s2 = getInput("Enter value 2: ");
        double result = addValues(s1, s2);
        System.out.println("The result is " + result);

        double result2 = addValues(s1, s2, s1, s2);
        System.out.println("The answer from multiple values is " + result2);
    }

    private static String getInput(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static double addValues(String s1, String s2) {
        double d1 = Double.parseDouble(s1);
        double d2 = Double.parseDouble(s2);
        return d1 + d2;
    }

    private static double addValues(String... values) {
        double result = 0;
        for (String str:
             values) {
            double d = Double.parseDouble(str);
            result += d;
        }
        return result;
    }
}
