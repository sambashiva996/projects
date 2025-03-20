package com.core.java.programs.practice;

/*Singleton Design Pattern*/
public class SingletonDesignPattern {

    private static SingletonDesignPattern SINGLETON_DESIGN_PATTERN;

    private SingletonDesignPattern(){}

    public static SingletonDesignPattern getInstance(){

        synchronized (SingletonDesignPattern.class){
            if (SINGLETON_DESIGN_PATTERN == null){
                SINGLETON_DESIGN_PATTERN = new SingletonDesignPattern();
            }
        }
        return SINGLETON_DESIGN_PATTERN;
    }

    public static void main(String[] args) {
        SingletonDesignPattern singletonDesignPattern = SingletonDesignPattern.getInstance();
        SingletonDesignPattern singletonDesignPattern1 = SingletonDesignPattern.getInstance();

        System.out.println(singletonDesignPattern);
        System.out.println(singletonDesignPattern1);
    }

}
