package com.github.xtralife.leetcode.problems.p91.decode_ways;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assert solution.numDecodings("2101") == 1;
    }
}
