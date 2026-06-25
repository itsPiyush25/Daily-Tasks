package com.example.Practice.leetcode.firstWeek;

public class CanPlaceFlower {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1},2));
        System.out.println(canPlaceFlowers(new int[]{1,0,1,0,1},3));
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,0},1));
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        // base case
        if(n==0)
            return true;

        int count = 0;

            /* *  logic part
            A flower can be planted at index i if:
            flowerbed[i] == 0
            Left plot is empty or doesn't exist.
            Right plot is empty or doesn't exist.
            * */
        for (int i = 0; i <flowerbed.length ; i++) {
            if(flowerbed[i]==0){
                boolean leftEmpty = ((i==0) || flowerbed[i-1]==0);
                boolean rightEmpty = (i==flowerbed.length - 1) || flowerbed[i+1]==0;

                if(leftEmpty && rightEmpty){
                    flowerbed[i] = 1;
                    count++;

                    if (count>=n){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
