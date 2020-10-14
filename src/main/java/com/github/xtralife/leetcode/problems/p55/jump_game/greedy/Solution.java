package com.github.xtralife.leetcode.problems.p55.jump_game.greedy;

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        int leftMost = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= leftMost) {
                leftMost = i;
            }
        }
        return leftMost == 0;
    }
}
