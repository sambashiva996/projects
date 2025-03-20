package com.core.java.programs.practice;

public class Demo {
    public static void main(String[] args) {

//        andAndOperatorUsecases();

//        stringsUseCases();


    }

    private static void stringsUseCases() {
        String s = "samba";
        String s1 = "samba";
        String s2 = new String("samba").intern();

        System.out.println(s==s2);
    }

    private static void andAndOperatorUsecases() {
        int a = 1;
        int b = 1;

        if ((a == 1) & (b++ == 2)) {  // b is incremented regardless
            System.out.println("Using & : Condition met");
        }
        System.out.println("b after & : " + b); // Output: 3

        b = 2; // Reset b

        if ((a == 1) && (b++ == 2)) {  // b is incremented only if first condition is true
            System.out.println("Using && : Condition met");
        }
        System.out.println("b after && : " + b); // Output: 3
    }
}
