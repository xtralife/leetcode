package com.github.xtralife.leetcode.problems.p207.course_schedule.bruteforce;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] canFinish = new boolean[numCourses];
        boolean updated;
        do {
            updated = false;
            course:
            for (int i = 0; i < numCourses; i++) {
                if (canFinish[i]) {
                    continue;
                }
                for (int[] pre : prerequisites) {
                    if (pre[0] != i) {
                        continue;
                    }
                    if (!canFinish[pre[1]]) {
                        continue course;
                    }
                }
                canFinish[i] = true;
                updated = true;
            }
        } while (updated);
        for (boolean finCourse : canFinish) {
            if (!finCourse) {
                return false;
            }
        }
        return true;
    }
}
