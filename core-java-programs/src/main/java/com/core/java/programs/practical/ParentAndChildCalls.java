package com.core.java.programs.practical;

public class ParentAndChildCalls {

    public static void main(String[] args) {
        Parent1 p = new Child1();
        System.out.println(p.i);
    }
}
class Parent1{
    int i=10;
}
class Child1 extends Parent1{
    int i=20;
}
