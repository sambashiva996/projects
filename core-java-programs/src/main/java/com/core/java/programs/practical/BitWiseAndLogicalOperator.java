package com.core.java.programs.practical;

public class BitWiseAndLogicalOperator {

    public static void main(String[] args) {
        int a = 0;
        int b = 1;

        if ((a == 1) & (b++ == 2)) {
            System.out.println("Both conditions are true.");
        }
        System.out.println("Value of b after & operation: " + b); // b is incremented

        b = 1; // Reset b
        if ((a == 1) && (b++ == 2)) {
            System.out.println("Both conditions are true.");
        }
        System.out.println("Value of b after && operation: " + b); // b is not incremented
    }

}
