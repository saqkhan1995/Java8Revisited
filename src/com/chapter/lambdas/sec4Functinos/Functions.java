package com.chapter.lambdas.sec4Functinos;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class Functions {

    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red Ridinghood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = Arrays.asList(john, tim, jack, snow, red, charming);

        //Lambda expressions using a "Function" interface which contains "apply" method
        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ')+1);
        };

        String lastName = getLastName.apply(employees.get(2));
        System.out.println("Last name is "+lastName);

        System.out.println("===============================");

        //Another example
        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        String firstName = getFirstName.apply(employees.get(2));
        System.out.println("First name is "+lastName);

        System.out.println("===============================");

        //Another example
        Random random = new Random();
        for (Employee employee: employees) {
            if (random.nextBoolean()) {
                System.out.println(getAName(getFirstName, employee));
            } else {
                System.out.println(getAName(getLastName, employee));
            }
        }

    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
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
