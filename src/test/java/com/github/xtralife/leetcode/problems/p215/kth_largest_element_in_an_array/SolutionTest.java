package com.github.xtralife.leetcode.problems.p215.kth_largest_element_in_an_array;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assert solution.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2) == 5;
        assert solution.findKthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4) == 4;
    }
}
