package com.github.xtralife.leetcode.problems.p1673.find_the_most_competitive_subsequence;

import java.util.Stack;

public class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int index = 0;
        Stack<Integer> seq = new Stack<>();
        while (index < nums.length) {
            int num = nums[index++];
            int removeCount = Math.min(seq.size(), seq.size() + nums.length - index + 1 - k);
            for (int i = 0; i < removeCount; i++) {
                if (seq.peek() > num) {
                    seq.pop();
                } else {
                    break;
                }
            }
            if (seq.size() < k) {
                seq.push(num);
            }
        }
        return seq.stream().mapToInt(i -> i).toArray();
    }
}

