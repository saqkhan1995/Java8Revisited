package com.chapter.lambdas.sec1Lambdas;

class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread 1 is running");
    }
}

public class lambda2 {
    public static void main(String[] args) {

        //Without Lambdas
        new Thread(new CodeToRun()).start();

        //Without Lambdas
        new Thread(new Runnable() {     //This boiler plate code is hat we refer to as anonymous inner class
            @Override
            public void run() {
                System.out.println("Thread 2 is running");
            }
        }).start();

        //With Lambda
        new Thread(() -> System.out.println("Printing from runnable interface method")).start();
        new Thread(() -> {
            System.out.println("Printing from runnable interface method - Line1");
            System.out.println("Printing from runnable interface method - Line2");
        }).start();

    }
}
