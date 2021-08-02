package com.chapter.Streams.sec1Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Section1 {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
          "N40", "N36",
          "B12", "B6",
          "G53", "G49", "G60", "G50", "g64",
          "I26", "I17", "I29",
          "O71");

        List<String> gNumbers = new ArrayList<>();

        //Without Streams
        someBingoNumbers.forEach(number -> {
            if(number.toUpperCase().startsWith("G")) {
                gNumbers.add(number);
                System.out.println(number);
            }
        });

        System.out.println("========================");

        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
        gNumbers.forEach(gNumber -> System.out.println(gNumber));

        //With Stream API
        //Stream is a set of object references
        //Each object reference in the stream corresponds to an object in the collection
        //sequence of elements supporting sequential & parallel aggregate operations

        someBingoNumbers.stream()
                .map(String::toUpperCase) //Method reference //Map method accepts a Fuction(java.util.function) functional interface that accepts an argument & returns a value
//                .map(s->s.toUpperCase()) //Without method reference, this should work as well
                .filter(s-> s.startsWith("G"))   //filter method requires a predicate, hence we pass a lambda expression which takes one parameter & returns a true/false. Resulting stream will contain only those values for which the predicate returned true.
                .sorted()
                .forEach(System.out::println);

        //Steam pipeline consists of Intermediate & Terminal Operations

    }
}
