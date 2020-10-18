package com.github.xtralife.leetcode.problems.p57.insert_intervals.optimized;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> res = new ArrayList<>();
        int p = 0;
        while (p < intervals.length && intervals[p][1] < newInterval[0]) {
            res.add(intervals[p++]);
        }
        while (p < intervals.length && overlaps(intervals[p], newInterval)) {
            newInterval[0] = Math.min(intervals[p][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[p][1], newInterval[1]);
            p++;
        }
        res.add(newInterval);
        while (p < intervals.length) {
            res.add(intervals[p++]);
        }
        return res.toArray(new int[res.size()][]);
    }

    private boolean overlaps(int[] int1, int[] int2) {
        return int2[0] <= int1[1] && int1[0] <= int2[1];
    }
}
