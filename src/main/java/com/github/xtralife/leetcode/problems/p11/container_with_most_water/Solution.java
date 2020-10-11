package com.github.xtralife.leetcode.problems.p11.container_with_most_water;

public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            int area = (end - start) * Math.min(height[start], height[end]);
            maxArea = Math.max(maxArea, area);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }
}
