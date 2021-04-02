package com.github.xtralife.leetcode.problems.p43.multiply_strings;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        String result = solution.multiply("123", "456");
        assert result.length() == 5;
    }
}
