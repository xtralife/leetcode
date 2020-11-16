package com.github.xtralife.leetcode.problems.p207.course_schedule.dfs_memo;

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
        boolean[] globalVisited = new boolean[numCourses];
        boolean[] currentVisited = new boolean[numCourses];
        for (int course = 0; course < numCourses; course++) {
            if (hasCycle(course, pres, globalVisited, currentVisited)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int course, Map<Integer, Set<Integer>> pres, boolean[] global, boolean[] local) {
        if (global[course]) {
            return false;
        }
        if (local[course]) {
            return true;
        }
        local[course] = true;
        for (int preCourse : pres.get(course)) {
            if (hasCycle(preCourse, pres, global, local)) {
                local[course] = false;
                return true;
            }
        }
        local[course] = false;
        global[course] = true;
        return false;
    }
}
