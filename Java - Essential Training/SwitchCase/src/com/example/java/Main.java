package com.example.java;

public class Main {

    public static void main(String[] args) {

        int month = 0;

        switch (month) {
            case 0:
                System.out.println("It's January!");
                break;
            case 1:
                System.out.println("It's February!");
                break;
            case 2:
                System.out.println("It's March!");
                break;
            default:
                System.out.println("It's some other month!");
        }

        switch (month) {
            case 0:
//                System.out.println("It's January!");
//                break;
            case 1:
//                System.out.println("It's February!");
//                break;
            case 2:
                System.out.println("It's Quarter 1!");
                break;
            default:
                System.out.println("It's some other month!");
        }

        String monthName = "February";
        switch (monthName) {
            case "January":
                System.out.println("It's the first month.");
                break;
            default:
                System.out.println("It isn't January");
        }

    }
}
