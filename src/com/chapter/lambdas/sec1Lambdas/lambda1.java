package com.chapter.lambdas.sec1Lambdas;


//FunctionalInterface
interface InterfaceFunctional {
    public void something();
}


public class lambda1 {

    public static void main(String[] args) {

        //Example 1 -----........................-----........................

        //Without Lambdas
        InterfaceFunctional obj2 = new InterfaceFunctional() {  //This boiler plate code is hat we refer to as anonymous inner class
            @Override
            public void something() {
                System.out.println("inside something() -> obj2");
            }
        };
        obj2.something();

        //With Lambdas
        InterfaceFunctional obj3 = () -> System.out.println("inside something() -> obj3");
        obj3.something();


        //Example 2 -----........................-----........................

        //Thread Example without lambda
        Runnable r1=new Runnable(){ //This boiler plate code is hat we refer to as anonymous inner class
            public void run(){
                System.out.println("Thread1 is running...");
            }
        };
        Thread t1=new Thread(r1);
        t1.start();
        //Thread Example with lambda
        Runnable r2=()->{
            System.out.println("Thread2 is running...");
        };
        Thread t2=new Thread(r2);
        t2.start();
    }

}


//    Why use Lambda Expression
//          - To provide the implementation of Functional interface.
//          - Less coding.

//        Java Lambda Expression Syntax
//        (argument-list) -> {body}
//        Java lambda expression is consisted of three components.
//        1) Argument-list: It can be empty or non-empty as well.
//        2) Arrow-token: It is used to link arguments-list and body of expression.
//        3) Body: It contains expressions and statements for lambda expression.

