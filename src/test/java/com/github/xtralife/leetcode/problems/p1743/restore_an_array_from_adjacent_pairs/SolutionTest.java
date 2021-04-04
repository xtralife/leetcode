package com.github.xtralife.leetcode.problems.p1743.restore_an_array_from_adjacent_pairs;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] result = solution.restoreArray(new int[][] {{2,1},{3,4},{3,2}});
        assert result.length == 4;
    }
}
