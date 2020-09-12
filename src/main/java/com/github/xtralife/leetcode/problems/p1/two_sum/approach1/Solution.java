package com.github.xtralife.leetcode.problems.p1.two_sum.approach1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> wantTo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (wantTo.containsKey(nums[i])) {
                return new int[] {wantTo.get(nums[i]), i};
            }
            wantTo.put(target - nums[i], i);
        }
        return null;
    }
}
