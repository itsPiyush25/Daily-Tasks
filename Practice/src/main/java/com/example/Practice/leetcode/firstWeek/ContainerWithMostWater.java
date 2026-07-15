package com.example.Practice.leetcode.firstWeek;

import java.util.List;
import java.util.Map;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right){
            // calculate current area = breadth X length
            int recentArea = (right - left)*(Math.min(height[left],height[right]));
            // update max area if needed
            maxArea = Math.max(recentArea,maxArea);
            // move one pointer
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}

