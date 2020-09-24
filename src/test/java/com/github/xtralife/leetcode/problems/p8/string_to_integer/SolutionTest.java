package com.github.xtralife.leetcode.problems.p8.string_to_integer;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assert solution.myAtoi("42") == 42;
        assert solution.myAtoi("-91283472332") == -2147483648;
    }
}
