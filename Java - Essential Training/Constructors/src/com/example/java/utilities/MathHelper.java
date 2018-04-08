package com.example.java.utilities;

public class MathHelper {
    private int total;

    public MathHelper() {
        System.out.println("Constructor called");
        total = 50;
    }

    public MathHelper(int total) {
        this();
        this.total += total;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int addNumber(String prompt) throws NumberFormatException {
        String input = InputHelper.getInput(prompt);
        int value = Integer.parseInt(input);
        total += value;
        return value;
    }
}