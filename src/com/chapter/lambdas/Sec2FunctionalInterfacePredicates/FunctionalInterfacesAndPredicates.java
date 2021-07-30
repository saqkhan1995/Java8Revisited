package com.chapter.lambdas.Sec2FunctionalInterfacePredicates;

import java.util.Arrays;
import java.util.List;

public class FunctionalInterfacesAndPredicates {

    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 24);
        Employee jack = new Employee("Jack Hill", 25);
        Employee snow = new Employee("Snow White", 26);

        List<Employee> employees = Arrays.asList(john, tim, jack, snow);

        //WITHOUT LAMBDAS
        for (Employee employee: employees) {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        }

        System.out.println("-----------------------------------------------------------");

        //WITH LAMBDAS
        //forEach is essentially a Consumer (open impl ctrl+B to see), Consumer as in takes in i/p but no o/p.
        //Consumer here is a functional interface, & hence we can make use of lambda expression in the body
        // (instead of traditional for or enhanced for loop without lambdas for iterating over lists)
        //forEach similar to enhanced for loop
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });
    }
}

// java.util.function contains over 30 functional interfaces


class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


