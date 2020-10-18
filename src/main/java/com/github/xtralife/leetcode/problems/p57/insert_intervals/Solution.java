package com.github.xtralife.leetcode.problems.p57.insert_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> newInts = new ArrayList<>();
        if (newInterval[1] < intervals[0][0]) {
            newInts.add(newInterval);
            newInts.addAll(Arrays.asList(intervals));
            return newInts.toArray(new int[newInts.size()][]);
        }
        if (newInterval[0] > intervals[intervals.length - 1][1]) {
            newInts.addAll(Arrays.asList(intervals));
            newInts.add(newInterval);
            return newInts.toArray(new int[newInts.size()][]);
        }

        boolean wasAdded = false;
        for (int[] interval : intervals) {
            if (overlaps(interval, newInterval)) {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                if (newInterval[1] < interval[0] && !wasAdded) {
                    newInts.add(newInterval);
                    wasAdded = true;
                }
                newInts.add(interval);
            }
        }
        if (!wasAdded) {
            newInts.add(newInterval);
        }
        return newInts.toArray(new int[newInts.size()][]);
    }

    private boolean overlaps(int[] int1, int[] int2) {
        return int2[0] <= int1[1] && int1[0] <= int2[1];
    }
}
