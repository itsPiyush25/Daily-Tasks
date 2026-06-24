package com.example.Practice.leetcode.firstWeek;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<=nums.length;i++){

            int missingNum = target - nums[i];

            if(map.containsKey(missingNum)){
                return new int[]{map.get(missingNum),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println((Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))));
    }
}
