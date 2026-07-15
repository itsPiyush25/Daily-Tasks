package com.example.Practice.leetcode.firstWeek;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamPracticeSets {

    public static void main(String[] args) {
        System.out.println(toUpperCaseConversion(Arrays.asList("apple", "banana", "grape", "orange")));
        sentencesToWords();
    }

    private static void sentencesToWords() {
        List<String> sentences = List.of("Java is great",
                "Spring Boot is great",
                "Java makes development easy");

        String collect = sentences.stream()
                .flatMap(s -> Arrays.stream(s.split("\\s+")))
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.joining(", "));

        System.out.println(collect);


    }

    private static List<String> toUpperCaseConversion(List<String> list) {

        return list.stream()
                .map(s-> String.valueOf(Character.toUpperCase(s.charAt(0))))
                .collect(Collectors.toList());
    }



}
