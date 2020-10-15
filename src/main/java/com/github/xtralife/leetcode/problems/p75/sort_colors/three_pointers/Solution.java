package com.github.xtralife.leetcode.problems.p75.sort_colors.three_pointers;

public class Solution {
    public void sortColors(int[] nums) {
        int reds = 0;
        int blues = nums.length - 1;
        int current = 0;
        while (current <= blues) {
            if (nums[current] == 2) {
                nums[current] = nums[blues];
                nums[blues--] = 2;
            } else if (nums[current] == 0) {
                nums[current++] = nums[reds];
                nums[reds++] = 0;
            } else {
                current++;
            }
        }
    }
}
