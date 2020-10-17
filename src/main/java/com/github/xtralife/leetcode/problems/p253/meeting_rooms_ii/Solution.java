package com.github.xtralife.leetcode.problems.p253.meeting_rooms_ii;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Comparator<List<Integer>> comparator = (a, b) -> {
            if (a.get(0).equals(b.get(0))) {
                return Comparator.<Integer>naturalOrder().compare(a.get(1), b.get(1));
            }
            return Comparator.<Integer>naturalOrder().compare(a.get(0), b.get(0));
        };
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(comparator);
        for (int[] interval : intervals) {
            queue.add(Arrays.asList(interval[0], 1));
            queue.add(Arrays.asList(interval[1], -1));
        }
        int maxRooms = 0;
        int currRooms = 0;
        while (!queue.isEmpty()) {
            List<Integer> time = queue.poll();
            currRooms += time.get(1);
            maxRooms = Math.max(maxRooms, currRooms);
        }
        return maxRooms;
    }
}
