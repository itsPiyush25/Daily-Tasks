package com.example.Practice.leetcode.firstWeek;

import java.util.List;

public class highestSalary {
    public static void main(String[] args) {
        List<Integer> integers = List.of(23000, 89000, 14000, 67000, 2100);
        int max = integers.get(0);
        int secondMax = 0;
        for (int i = 0; i < integers.size(); i++) {
//            if (integers.get(i) > max){
//                max = integers.get(i);
//            }
            if (integers.get(i) > max){
                secondMax = max;
                max = integers.get(i);
            } else if (integers.get(i) > secondMax && integers.get(i)!=max) {
                secondMax = integers.get(i);
            }
        }

        System.out.println("max salary : "+max);
        System.out.println("second max salary : "+secondMax);

    }
}
