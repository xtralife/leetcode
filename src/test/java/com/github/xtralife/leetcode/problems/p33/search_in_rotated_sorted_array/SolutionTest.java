package com.github.xtralife.leetcode.problems.p33.search_in_rotated_sorted_array;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assert solution.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0) == 4;
        assert solution.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 3) == -1;
        assert solution.search(new int[] {5, 1, 2, 3, 4}, 1) == 1;
    }
}
