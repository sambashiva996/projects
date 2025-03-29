package com.core.java.programs.practical;

import java.io.IOException;
import java.sql.SQLException;

public class MethodOverrideCalls {

    public static void main(String[] args) {

        Parent c = new Child();
        System.out.println(c.n);
    }
}

    class Parent{
    int n = 10;
        public void m1(){
            System.out.println("Parent m1 method");
        }
        protected void m2() throws Exception {
            System.out.println("Parent m2 method");
        }
    }
    class Child extends Parent{
    int n = 20;
        public void m1(){
            System.out.println("Child m1 method");
        }
        public void m3(){
            System.out.println("Child m3 method");
        }
        public void m2() throws Exception{
            System.out.println("test");
        }
    }
