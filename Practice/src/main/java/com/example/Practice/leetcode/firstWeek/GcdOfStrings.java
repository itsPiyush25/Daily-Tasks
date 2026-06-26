package com.example.Practice.leetcode.firstWeek;

/*
* For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"

Output: "ABC"

Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"

Output: "AB"

Example 3:

Input: str1 = "LEET", str2 = "CODE"

Output: ""
* */
public class GcdOfStrings {
    public static void main(String[] args) {
//        String s1 = "ABCABC",s2= "ABC";
//        String s1 = "ABAB",s2= "ABABAB";
        String s1 = "LEFT",s2= "CODE";
        System.out.println("GCD of Strings : " + gcdOfStrings(s1,s2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        //TODO : gcd logic implementation

        //base case
        // common divisor string is exist or not

        if (!(str1 + str2).equals(str2 + str1))
            return "";

        int gcdLength = gcd(str1.length(),str2.length());

        return str1.substring(0,gcdLength);
    }

    private static int gcd(int a, int b) {
        while (b!=0){
           int temp = b;
           b = a%b;
           a = temp;
        }
        return a;
    }
}

