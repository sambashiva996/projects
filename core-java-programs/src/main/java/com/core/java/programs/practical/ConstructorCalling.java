package com.core.java.programs.practical;

public class ConstructorCalling {
    private int id;
    private String name;

    public ConstructorCalling(){
        this(1,"test");
        System.out.println("Constructor called");
    }
    public ConstructorCalling(int id, String name){
        System.out.println("Params Constructor called : "+id +" : "+ name);
    }

    public void callConstructor(){
        System.out.println("callConstructor method called");
    }

    public static void main(String[] args) {
        ConstructorCalling constructorCalling = new ConstructorCalling();
        constructorCalling.callConstructor();
    }
}
