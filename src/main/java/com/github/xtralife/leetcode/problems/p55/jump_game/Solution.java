package com.github.xtralife.leetcode.problems.p55.jump_game;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }

        Set<Integer> canJump = new HashSet<>();
        canJump.add(nums.length - 1);
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length && j < i + 1 + nums[i]; j++) {
                if (canJump.contains(j)) {
                    canJump.add(i);
                    break;
                }
            }
        }
        return canJump.contains(0);
    }
}
