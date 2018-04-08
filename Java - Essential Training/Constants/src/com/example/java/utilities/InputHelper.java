package com.example.java.utilities;

import java.util.Scanner;

public class InputHelper {

    public static String getInput(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}