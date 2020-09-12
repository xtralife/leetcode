package com.github.xtralife.leetcode.problems.p136.single_number.approach1;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.stream().findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
