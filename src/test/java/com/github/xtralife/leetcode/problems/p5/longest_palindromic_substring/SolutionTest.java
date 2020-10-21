package com.github.xtralife.leetcode.problems.p5.longest_palindromic_substring;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assert solution.longestPalindrome("aacabdkacaa").length() == 3;
    }
}
