package com.example.Practice.eighthJuly;

import java.util.List;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(23, -4, -9, 12, 0);

        List<Integer> list = integerStream.filter(x -> x > 0).toList();

        List<Integer> list1 = list.stream().map(x -> x / 2).toList();

        System.out.println(list1);

        System.out.println("====================================");

        list1.forEach(System.out::println);

        System.out.println("====================================");

        list.forEach(System.out::println);

        System.out.println("====================================");

    }
}
