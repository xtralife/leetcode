package com.github.xtralife.leetcode.problems.p76.minimum_window_substring;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        String result = solution.minWindow("ADOBECODEBANC", "ABC");
        assert result != null;
    }
}
