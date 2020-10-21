package com.github.xtralife.leetcode.problems.p219.contains_duplicate_ii;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 1) {
            return false;
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i])) {
                return true;
            }
            if (i - k >= 0) {
                seen.remove(nums[i - k]);
            }
            seen.add(nums[i]);
        }
        return false;
    }
}
