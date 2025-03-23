package com.core.java.programs.threads;

public class SharedResource {
    private boolean isOdd = true;
    public synchronized void printOdd(int oddNum) {

        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(Thread.currentThread().getName()+" : "+oddNum);
        isOdd = false;
        notify();
    }

    public synchronized void printEven(int evenNum) {

        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(Thread.currentThread().getName()+" : "+evenNum);
        isOdd = true;
        notify();
    }
}
