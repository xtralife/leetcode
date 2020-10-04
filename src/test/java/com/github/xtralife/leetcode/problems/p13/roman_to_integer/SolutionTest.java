package com.github.xtralife.leetcode.problems.p13.roman_to_integer;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();

        assert solution.romanToInt("XLIII") == 43;
    }
}
