package com.core.java.programs.practical;

public class ClassLoadingExample {

    public static void main(String[] args) {
        new ClassLoadExample();
        new ClassLoadExample(2);
    }
}

class ClassLoadExample{
    public ClassLoadExample(){
        System.out.println("default constructor");
    }
    public ClassLoadExample(int a){
        System.out.println("Parameterized constructor : "+a);
    }
    {
        System.out.println("Instance block ");
    }
    {
        System.out.println("Instance block one");
    }
    static {
        System.out.println("static block two");
    }
    static {
        System.out.println("static block one");
    }

    /*
    * OutPut: static block two
                static block one
                Instance block
                Instance block one
                default constructor
                Instance block
                Instance block one
                Parameterized constructor : 2
    * */
}
