package com.github.xtralife.leetcode.problems.p435.non_overlapping_intervals;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] curr = intervals[0];
        int removed = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (areOverlapping(curr, intervals[i])) {
                removed++;
                if (curr[1] > intervals[i][1]) {
                    curr = intervals[i];
                }
            } else {
                curr = intervals[i];
            }
        }
        return removed;
    }

    private boolean areOverlapping(int[] first, int[] second) {
        return second[0] < first[1];
    }
}
