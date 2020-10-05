package com.github.xtralife.leetcode.problems.p523.continuous_subarray_sum.modulus_set;

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
        mods.add(nums[0] % k);
        for (int i = 1; i < nums.length; i++) {
            int currMod = nums[i] % k;
            Set<Integer> newMods = new HashSet<>();
            newMods.add(currMod);
            for (int mod : mods) {
                int newMod = (currMod + mod) % k;
                if (newMod == 0) {
                    return true;
                }
                newMods.add(newMod);
            }
            mods = newMods;
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
