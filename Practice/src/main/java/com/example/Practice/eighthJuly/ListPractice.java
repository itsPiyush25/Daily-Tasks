package com.example.Practice.eighthJuly;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ListPractice {
    public static void main(String[] args) {
        LinkedList<String> fruitList = new LinkedList<>();

        fruitList.add("Apple");
        fruitList.addFirst("Melon");
        fruitList.add("Guava");
        fruitList.addLast("Berry");

        boolean isApple = fruitList.stream()
                .anyMatch(st -> st.matches("Melon"));

        System.out.println(isApple);
        System.out.print(fruitList);

    }

}
