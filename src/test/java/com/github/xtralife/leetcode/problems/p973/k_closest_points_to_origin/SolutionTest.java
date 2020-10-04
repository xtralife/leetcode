package com.github.xtralife.leetcode.problems.p973.k_closest_points_to_origin;

import org.testng.annotations.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();

        int[][] result = solution.kClosest(new int[][]{{0, 1}, {1, 0}}, 2);
        System.out.println(Arrays.toString(result));
    }
}
