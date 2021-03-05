package com.github.xtralife.leetcode.problems.p986.interval_list_intersections;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[][] A = {{0,2}, {5,10}, {13,23}, {24, 25}};
        int[][] B = {{1,5}, {8,12}, {15,24}, {25, 26}};
        int[][] result = solution.intervalIntersection(A, B);
        assert result.length == 6;
    }
}
