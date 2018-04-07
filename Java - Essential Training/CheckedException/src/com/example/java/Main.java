package com.example.java;

public class Main {

    public static void main(String[] args) {

        try {
            String welcome = "Welcome!";
            char[] chars = welcome.toCharArray();
            char lastChar = chars[chars.length - 1];
            System.out.println("Last char: " + lastChar);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index exception");
            e.printStackTrace();
            return;
        } catch (Exception e) {
            System.out.println("Any exception");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            doSomething();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Code ran successfully");
    }

    public static void doSomething() throws InterruptedException {
        Thread.sleep(1000);
    }
}
