package com.core.java.programs.threads;

public class ThreadCommunication {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Runnable r1 = () -> {
            for (int i = 1; i <=10; i +=2) {
               sharedResource.printOdd(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable r2 = () -> {
            for (int j = 2; j <= 10; j +=2){
                sharedResource.printEven(j);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread t1 = new Thread(r1,"oddThread");
        Thread t2 = new Thread(r2, "evenThread");

        t1.start();
        t2.start();
    }
}
