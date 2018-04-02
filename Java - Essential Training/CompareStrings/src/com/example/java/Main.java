package com.example.java;

public class Main {

    public static void main(String[] args) {

        String s1 = "Hello!";
        String s2 = "Hello!";

        if (s1 == s2) {
            System.out.println("They match!");
        } else {
            System.out.println("They don't match!");
        }

        String s3 = new String("Hello!");
        String s4 = new String("Hello!");
        if (s3 == s4) {
            System.out.println("They match!");
        } else {
            System.out.println("They don't match!");
        }
//      if (s3.equalsIgnoreCase(s4))
        if (s3.equals(s4)) {
            System.out.println("They match!");
        } else {
            System.out.println("They don't match!");
        }

    }
}
