package com.chapter.Streams.sec2Streams2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red Ridinghood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = Arrays.asList(john, jane, jack, snow, red, charming);

        employees.forEach(employee -> System.out.println(employee));

        Department hr = new Department("Human resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);


        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        List<Employee> emp = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.toList());

        Iterator itr = emp.iterator();
        while (itr.hasNext()) {
            System.out.println(itr);
        }



    }
}



// Home / Java 8 / Java Stream flatMap()
//         Java Stream flatMap()
//
//
//         Java 8 Stream flatMap() method is used to flatten a Stream of collections to a stream of objects.
//         The objects are combined from all the collections in the original Stream.
//
//         The flatMap() operation has the effect of applying a one-to-many transformation to the elements of the stream
//         and then flattening the resulting elements into a new stream.
//
//         Stream.flatMap() helps in converting Stream<Collection<T>> to Stream<T>.
//
//        flatMap() = Flattening + map()
//
//        1. What is Flattening?
//        In very layman terms, flattening is referred to as merging multiple collections/arrays into one.
//        Consider the following examples.
//
//        In the given example, we have an array of 3 arrays.
//        After the flattening effect, we will have one result array with all the items in three arrays.
//
//        Flattening example 1
//        Before flattening   : [[1, 2, 3], [4, 5], [6, 7, 8]]
//        After flattening    : [1, 2, 3, 4, 5, 6, 7, 8]
