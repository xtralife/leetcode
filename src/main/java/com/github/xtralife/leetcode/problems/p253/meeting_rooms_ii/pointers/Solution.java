package com.github.xtralife.leetcode.problems.p253.meeting_rooms_ii.pointers;

import java.util.Arrays;

public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = Arrays.stream(intervals).mapToInt(a -> a[0]).toArray();
        int[] ends = Arrays.stream(intervals).mapToInt(a -> a[1]).toArray();
        Arrays.sort(starts);
        Arrays.sort(ends);
        int sp = 0;
        int ep = 0;
        int maxRooms = 0;
        int currRooms = 0;
        while (sp < starts.length) {
            if (starts[sp] < ends[ep]) {
                currRooms++;
                sp++;
                maxRooms = Math.max(maxRooms, currRooms);
            } else {
                currRooms--;
                ep++;
            }
        }
        return maxRooms;
    }
}
