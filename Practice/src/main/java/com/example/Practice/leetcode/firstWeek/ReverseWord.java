package com.example.Practice.leetcode.firstWeek;

import java.util.Arrays;

public class ReverseWord {
    public static void main(String[] args) {
       char[] cr =  {'h','e','l','l','o'};
        reverseString(cr);
        System.out.println(Arrays.toString(cr));
    }
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length -1;

        while(left < right){
            char c = s[left];
            s[left] = s[right];
            s[right] = c;

            left++;
            right--;
        }
    }
}
