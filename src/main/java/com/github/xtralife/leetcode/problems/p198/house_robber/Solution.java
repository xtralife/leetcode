package com.github.xtralife.leetcode.problems.p198.house_robber;

public class Solution {
    public int rob(int[] nums) {
        int prevMax = 0;
        int curMax = 0;
        for (int x : nums) {
            int temp = prevMax;
            prevMax = curMax;
            curMax = Math.max(temp + x, curMax);
        }
        return curMax;
    }
}
