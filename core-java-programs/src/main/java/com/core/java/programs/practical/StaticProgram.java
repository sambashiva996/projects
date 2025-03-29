package com.core.java.programs.practical;

public class StaticProgram {
    int d;
    int c;
    static int e = 1;

    StaticProgram() {
        System.out.println(++c);
        System.out.println(++e);
    }

    public static void main(String[] args) {
        int a = 20;
        int b = 15;
        new StaticProgram().c -= a++ + +b + ++new StaticProgram().c - new StaticProgram().d++;
        System.out.println("c-- " + new StaticProgram().c);
    }
}
