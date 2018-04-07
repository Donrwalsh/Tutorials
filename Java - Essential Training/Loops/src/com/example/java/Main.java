package com.example.java;

public class Main {

    private static String[] months =
            {"January", "February", "March",
                    "April", "May", "June",
                    "July", "August", "September",
                    "October", "November", "December"};

    public static void main(String[] args) {

        for (int i = 0; i < months.length; i++) {
            System.out.println(months[i]);
        }

        for (String month:
             months) {
            System.out.println(month);
        }

        int counter = 0;
        while (counter < months.length) {
            System.out.println(months[counter]);
            counter ++;
        }

        int counter2 = 0;
        do {
            System.out.println(months[counter2]);

            if (counter2 == 5) {
                break;
            }
        } while (counter2 < months.length);

        
    }
}
