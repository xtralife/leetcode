package com.github.xtralife.leetcode.problems.p56.merge_intervals.graph;

import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        Map<int[], List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            graph.putIfAbsent(intervals[i], new ArrayList<>());
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][1] >= intervals[j][0] && intervals[i][0] <= intervals[j][1]) {
                    graph.get(intervals[i]).add(intervals[j]);
                    graph.putIfAbsent(intervals[j], new ArrayList<>());
                    graph.get(intervals[j]).add(intervals[i]);
                }
            }
        }
        List<int[]> result = new LinkedList<>();
        Set<int[]> visited = new HashSet<>();
        for (Map.Entry<int[], List<int[]>> entry : graph.entrySet()) {
            int[] key = entry.getKey();
            if (visited.contains(key)) {
                continue;
            }
            int[] expanded = new int[2];
            expanded[0] = key[0];
            expanded[1] = key[1];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(key);
            while (!queue.isEmpty()) {
                int[] interval = queue.poll();
                expanded[0] = Math.min(expanded[0], interval[0]);
                expanded[1] = Math.max(expanded[1], interval[1]);
                visited.add(interval);
                List<int[]> neighbours = graph.get(interval);
                for (int[] neighbour : neighbours) {
                    if (visited.contains(neighbour)) {
                        continue;
                    }
                    queue.add(neighbour);
                }
            }
            result.add(expanded);
        }
        return result.toArray(new int[result.size()][]);
    }
}
