package com.github.xtralife.leetcode.problems.p75.sort_colors;

import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        int redCount = 0;
        int whiteCount = 0;
        for (int num : nums) {
            if (num == 0) {
                redCount++;
            }
            if (num == 1) {
                whiteCount++;
            }
        }
        Arrays.fill(nums, 0, redCount, 0);
        Arrays.fill(nums, redCount, redCount + whiteCount, 1);
        Arrays.fill(nums, redCount + whiteCount, nums.length, 2);
    }
}
