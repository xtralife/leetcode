package com.github.xtralife.leetcode.problems.p645.set_mismatch.set;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                result[0] = num;
            } else {
                seen.add(num);
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!seen.contains(i)) {
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
