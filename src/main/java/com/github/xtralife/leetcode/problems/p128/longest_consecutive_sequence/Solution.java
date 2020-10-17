package com.github.xtralife.leetcode.problems.p128.longest_consecutive_sequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> sequence = new HashMap<>();
        for (int num : nums) {
            if (sequence.containsKey(num)) {
                continue;
            }
            if (sequence.containsKey(num - 1) && sequence.containsKey(num + 1)) {
                int left = sequence.get(num - 1) + 1;
                int right = sequence.get(num + 1) + 1;
                sequence.put(num, -1);
                if (left > 1) {
                    sequence.put(num - 1, -1);
                }
                if (right > 1) {
                    sequence.put(num + 1, -1);
                }
                sequence.put(num - left, left + right);
                sequence.put(num + right, left + right);
                continue;
            }
            if (sequence.containsKey(num - 1)) {
                int left = sequence.get(num - 1) + 1;
                if (left > 1) {
                    sequence.put(num - 1, -1);
                }
                sequence.put(num - left, left);
                sequence.put(num, left);
                continue;
            }
            if (sequence.containsKey(num + 1)) {
                int right = sequence.get(num + 1) + 1;
                if (right > 1) {
                    sequence.put(num + 1, -1);
                }
                sequence.put(num + right, right);
                sequence.put(num, right);
                continue;
            }
            sequence.put(num, 0);
        }
        int maxSeq = 0;
        for (int seq : sequence.values()) {
            maxSeq = Math.max(maxSeq, seq);
        }
        return maxSeq + 1;
    }
}
