package com.github.xtralife.leetcode.problems.p523.continuous_subarray_sum;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        if (k == 0) {
            return zeroCase(nums);
        }
        Set<Integer> mods = new HashSet<>();
        mods.add(0);
        int sum = nums[0] % k;
        int prev = sum;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;
            if (mods.contains(sum)) {
                return true;
            }
            mods.add(prev);
            prev = sum;
        }
        return false;
    }

    private boolean zeroCase(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) {
                return true;
            }
        }
        return false;
    }
}
