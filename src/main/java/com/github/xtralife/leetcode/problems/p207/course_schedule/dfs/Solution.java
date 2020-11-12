package com.github.xtralife.leetcode.problems.p207.course_schedule.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> pres = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            pres.put(i, new HashSet<>());
        }
        for (int[] pre : prerequisites) {
            pres.get(pre[0]).add(pre[1]);
        }
        boolean[] visited = new boolean[numCourses];
        for (int course = 0; course < numCourses; course++) {
            if (hasCycle(course, pres, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int course, Map<Integer, Set<Integer>> pres, boolean[] visited) {
        if (visited[course]) {
            return true;
        }
        visited[course] = true;
        for (int preCourse : pres.get(course)) {
            if (hasCycle(preCourse, pres, visited)) {
                visited[course] = false;
                return true;
            }
        }
        visited[course] = false;
        return false;
    }
}
