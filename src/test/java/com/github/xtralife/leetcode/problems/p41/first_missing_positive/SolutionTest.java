package com.github.xtralife.leetcode.problems.p41.first_missing_positive;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assert solution.firstMissingPositive(new int[]{3, 4, -1, 1}) == 2;
    }
}
