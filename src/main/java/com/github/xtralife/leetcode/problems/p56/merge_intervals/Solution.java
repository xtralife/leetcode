package com.github.xtralife.leetcode.problems.p56.merge_intervals;

import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(interval -> interval.get(0)));
        for (int[] interval : intervals) {
            queue.add(Arrays.asList(interval[0], interval[1]));
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = queue.poll();
        while (!queue.isEmpty()) {
            List<Integer> next = queue.poll();
            if (curr.get(1) >= next.get(0)) {
                curr.set(1, Math.max(curr.get(1), next.get(1)));
            } else {
                res.add(curr);
                curr = next;
            }
        }
        res.add(curr);
        int[][] resArr = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            resArr[i][0] = res.get(i).get(0);
            resArr[i][1] = res.get(i).get(1);
        }
        return resArr;
    }
}
