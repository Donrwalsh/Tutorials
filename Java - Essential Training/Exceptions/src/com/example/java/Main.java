package com.example.java;

public class Main {

    public static void main(String[] args) {

        //Errors that stop from compiling and running:
        System.out.println("Hello world") //Syntax error here due to missing winkyboi
        Int x = 1 //Syntax error here due to incorrect declaration syntax
        String y = "Hello";
        int y = 4; //Syntax error here due to already existing identifier

        //Runtime errors:
        String welcome = "Welcome!";
        char[] chars = welcome.toCharArray();
        //Exception here due to asking for out of range value
        char lastChar = chars[chars.length];
        System.out.println("last char: " + lastChar);

        String nothing = null;
        System.out.println(nothing); //No problem here. Java knows to render the string "null"
        System.out.println("string length=" + nothing.length()); //Exception here due to nothing not actually being an object.
    }
}
