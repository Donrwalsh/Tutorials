package com.example.java.utilities;

public class MathHelper {

    //public static final String ADD = "add";
    //public static final String SUBTRACT = "subtract";

    private int total;

    public MathHelper(int total) {
        this.total += total;
    }

    public int getTotal() {
        return total;
    }

    public int doMath(String prompt, Operation operation) throws NumberFormatException {
        String input = InputHelper.getInput(prompt);
        int value = Integer.parseInt(input);

        switch(operation) {
            case ADD:
                total += value;
                break;
            case SUBTRACT:
                total -= value;


        }

        return value;
    }

    public enum Operation {
        ADD, SUBTRACT;
    }
}