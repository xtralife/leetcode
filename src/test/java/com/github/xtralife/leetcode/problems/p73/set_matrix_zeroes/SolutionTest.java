package com.github.xtralife.leetcode.problems.p73.set_matrix_zeroes;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        solution.setZeroes(new int[][]{{1, 2, 3, 4}, {5, 0, 7, 8,}, {0, 10, 11, 12}, {13, 14, 15, 0}});
    }
}
