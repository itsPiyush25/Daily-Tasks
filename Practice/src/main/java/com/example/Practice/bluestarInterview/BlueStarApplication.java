package com.example.Practice.bluestarInterview;

import java.util.Arrays;
import java.util.List;

public class BlueStarApplication {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("hello", "world");

// map: List<Integer> [5, 5]
        List<Integer> lengths = words.stream()
                .map(String::length)
                .toList();

// flatMap: flatten list of chars
        List<Character> chars = words.stream()
                .flatMap(s -> s.chars().mapToObj(c -> (char)c))
                .toList();

        System.out.println("length : "+lengths);
        System.out.println("chars : "+chars);

    }
}
