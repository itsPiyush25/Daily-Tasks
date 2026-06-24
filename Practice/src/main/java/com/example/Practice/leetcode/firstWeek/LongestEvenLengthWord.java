package com.example.Practice.leetcode.firstWeek;

import java.util.Arrays;
import java.util.Comparator;

public class LongestEvenLengthWord {
    public static void main(String[] args) {
        String sentence = "Time to write great code";
        System.out.println(longestWord(sentence));
    }

    private static String longestWord(String sentence) {

        String res = Arrays.stream(sentence.split(" "))
                .filter(word -> word.length() % 2 == 0)
                .max(Comparator.comparingInt(String::length))
                .orElse("00");

        return res;
    }


}
