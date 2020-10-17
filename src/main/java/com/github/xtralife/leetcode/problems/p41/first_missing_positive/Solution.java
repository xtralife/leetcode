package com.github.xtralife.leetcode.problems.p41.first_missing_positive;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int p = 0;
        while (p < nums.length) {
            if (nums[p] < 1 || nums[p] > nums.length || nums[p] == p + 1 || nums[p] == nums[nums[p] - 1]) {
                p++;
            } else {
                int swapIndex = nums[p] - 1;
                int temp = nums[p];
                nums[p] = nums[swapIndex];
                nums[swapIndex] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
