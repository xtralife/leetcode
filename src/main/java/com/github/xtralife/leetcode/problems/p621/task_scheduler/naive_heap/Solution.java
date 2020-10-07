package com.github.xtralife.leetcode.problems.p621.task_scheduler.naive_heap;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char ch : tasks) {
            counts[ch - 'A']++;
        }
        int maxCount = 0;
        int numMaxCounts = 0;
        for (int count : counts) {
            if (maxCount == count) {
                numMaxCounts++;
            }
            if (maxCount < count) {
                maxCount = count;
                numMaxCounts = 1;
            }
        }
        return Math.max((maxCount - 1) * n + numMaxCounts - 1, tasks.length - maxCount) + maxCount;
    }
}
