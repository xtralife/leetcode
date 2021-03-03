package com.github.xtralife.leetcode.problems.p268.missing_number.gauss;

public class Solution {
    public int missingNumber(int[] nums) {
        int expected = nums.length * (nums.length + 1) / 2;
        int actual = 0;
        for (int num : nums) {
            actual += num;
        }
        return expected - actual;
    }
}
