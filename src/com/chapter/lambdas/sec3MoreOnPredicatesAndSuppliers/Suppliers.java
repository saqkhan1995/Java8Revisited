package com.chapter.lambdas.sec3MoreOnPredicatesAndSuppliers;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Suppliers {

    public static void main(String[] args) {

        //Supplier is a functional Interface with a "get" method.
        // Doesn't take in any arguments but returns an o/p (other way round of consumer)

        //Without Supplier
        Random random = new Random();
        for (int i=0; i<10; i++) {
            System.out.println(random.nextInt(1000));
        }

        System.out.println("=================================");

        //Supplier
        Random random1 = new Random();
        Supplier<Integer> supplier = () -> random1.nextInt(1000);
        for (int i=0; i<10; i++) {
            System.out.println(supplier.get());
        }
    }


}



// java.util.function contains over 30 functional interfaces




