package com.chapter.lambdas.Sec2FunctionalInterfacePredicates;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class FunctionalInterfacesAndPredicates2 {

    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red Ridinghood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = Arrays.asList(john, tim, jack, snow, red, charming);


        System.out.println("Employees over 30");
        System.out.println("=================");

        //WITHOUT LAMBDAS
        for (Employee employee: employees) {
            if (employee.getAge()>30) {
                System.out.println(employee.getName());
            }
        }
        System.out.println("=================");
        //WITH LAMBDAS
        employees.forEach(employee -> {
            if(employee.getAge()>30) {
                System.out.println(employee.getName());
            }
        });

        System.out.println("Using Predicates");
        System.out.println("=================");

        //We can replace the if condition inside the lambda expre body with a "predicate" function
        //Predicate is a functional interface that contains a method "test" which returns a boolean
        // The predicate function has lambda expression arguments that match the interface
        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "Employess 30 & under", employee -> employee.getAge()<=30);

        //without lambdas, using anonymous inner classes to use "Predicate"
        printEmployeesByAge(employees, "Employees below 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        //Another exmaple of using Predicates
        IntPredicate intP = i -> i > 15;
        System.out.println(intP.test(10));  //false
    }

    public static void printEmployeesByAge(List<Employee> employees,
                                           String ageText,
                                           Predicate<Employee> ageCondition) {

        System.out.println(ageText);
        System.out.println("=================");
        for (Employee employee: employees) {
            if (ageCondition.test(employee)) {           // Predicate has a "test" method to execute the test condition
                System.out.println(employee.getName());
            }
        }

    }
}

// java.util.function contains over 30 functional interfaces




