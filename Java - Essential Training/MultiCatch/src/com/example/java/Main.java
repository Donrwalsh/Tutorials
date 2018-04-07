package com.example.java;

public class Main {

    public static void main(String[] args) {

        try {
            String welcome = "Welcome!";
            char[] chars = welcome.toCharArray();
            char lastChar = chars[chars.length-1];
            System.out.println("Last char: " + lastChar);

            String nothing = null;
            System.out.println(nothing.length());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Exception");
            e.printStackTrace();
            return;
        } catch (NullPointerException e) {
            System.out.println("Null Exception");
            e.printStackTrace();
            return;
        } catch (Exception e) {
            System.out.println("Any exception");
            return;
        }
        System.out.println("Code ran successfully");
    }
}
