package com.github.xtralife.leetcode.problems.p207.course_schedule.topological_sort;

import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> preCounts = new HashMap<>();
        Map<Integer, List<Integer>> poss = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preCounts.put(i, 0);
            poss.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            preCounts.put(pre[0], preCounts.get(pre[0]) + 1);
            poss.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int canFinish = 0;
        for (int i = 0; i < numCourses; i++) {
            if (preCounts.get(i) == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            canFinish++;
            for (int i : poss.get(course)) {
                preCounts.put(i, preCounts.get(i) - 1);
                if (preCounts.get(i) == 0) {
                    queue.add(i);
                }
            }
        }
        return canFinish == numCourses;
    }
}
