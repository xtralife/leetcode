package com.github.xtralife.leetcode.problems.p136.single_number.approach2;

public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
