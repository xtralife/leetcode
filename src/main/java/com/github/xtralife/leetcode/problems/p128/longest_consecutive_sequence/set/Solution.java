package com.github.xtralife.leetcode.problems.p128.longest_consecutive_sequence.set;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxSeq = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int seq = 0;
            while (set.contains(num)) {
                seq++;
                num++;
            }
            maxSeq = Math.max(maxSeq, seq);
        }
        return maxSeq;
    }
}
