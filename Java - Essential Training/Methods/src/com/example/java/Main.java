package com.example.java;

import java.util.Scanner;

public class Main {

    private static String[] months =
            {"January", "February", "March",
            "April", "May", "June",
            "July", "August", "September",
            "October", "November", "December"};

    public static void main(String[] args) {

//        loopMonths();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a month: ");
            String monthName = scanner.nextLine();
            if (monthName.equals("")) break;
            int monthNumber = getMonthNumber(monthName);
            if (monthNumber == -1) {
                System.out.println("Month not found.");
            } else {
                System.out.println(String.format(
                        "%s is month number %d", monthName, monthNumber+1));
            }
        }
    }

    private static void loopMonths() {
        for (int i = 0; i < months.length; i++) {
            System.out.println(months[i]);
        }
    }

    private static int getMonthNumber(String monthName) {
        for (int i = 0; i < months.length; i++) {
            if (months[i].equalsIgnoreCase(monthName)) return i;
        }
        return -1;
    }
}
