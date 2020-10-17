package com.github.xtralife.leetcode.problems.p253.meeting_rooms_ii.priority_by_end;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int[] interval : intervals) {
            if (!queue.isEmpty() && interval[0] >= queue.peek()[1]) {
                queue.poll();
            }
            queue.add(interval);
        }
        return queue.size();
    }
}
