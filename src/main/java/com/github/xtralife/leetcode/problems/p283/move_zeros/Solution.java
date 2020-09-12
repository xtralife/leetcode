package com.github.xtralife.leetcode.problems.p283.move_zeros;

public class Solution {
    public void moveZeroes(int[] nums) {
        int pointer = 0;
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
                continue;
            }
            if (zeros > 0) {
                nums[pointer] = nums[i];
            }
            pointer++;
        }
        if (zeros == 0) {
            return;
        }
        for (int i = pointer; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}