package com.chapter.lambdas.sec1Lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class lambda3 {

    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 24);
        Employee jack = new Employee("Jack Hill", 25);
        Employee snow = new Employee("Snow White", 26);

        List<Employee> employees = Arrays.asList(john, tim, jack, snow);

        //Without Lambdas
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });

        for (Employee employee: employees) {
            System.out.println("emp->"+employee.getName());
        }

        System.out.println("-----------------------------------------------------------");
        //with Lambdas
        List<Employee> employees2 = Arrays.asList(john, tim, jack, snow);
        Collections.sort(employees2, (emp1, emp2) -> emp1.getName().compareTo(emp2.getName()));

        for (Employee employee2: employees2) {
            System.out.println("emp2->"+employee2.getName());
        }

    }
}

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
