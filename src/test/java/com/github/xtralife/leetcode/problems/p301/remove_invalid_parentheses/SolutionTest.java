package com.github.xtralife.leetcode.problems.p301.remove_invalid_parentheses;

import org.testng.annotations.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assert solution.removeInvalidParentheses("()())()").containsAll(Arrays.asList("()()()", "(())()"));
        assert solution.removeInvalidParentheses("()))((()").contains("()()");
    }
}
