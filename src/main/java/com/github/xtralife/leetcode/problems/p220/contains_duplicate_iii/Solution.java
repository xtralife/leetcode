package com.github.xtralife.leetcode.problems.p220.contains_duplicate_iii;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 1) {
            return false;
        }
        NavigableSet<Integer> seen = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer higher = seen.ceiling(num);
            Integer lower = seen.floor(num);
            if (higher != null && (long) higher - num <= t) {
                return true;
            }
            if (lower != null && (long) num - lower <= t) {
                return true;
            }
            if (i - k >= 0) {
                seen.remove(nums[i - k]);
            }
            seen.add(num);
        }
        return false;
    }
}
