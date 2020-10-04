package com.github.xtralife.leetcode.problems.p1249.minimum_remove_to_make_valid_parentheses;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();

        assert solution.minRemoveToMakeValid("a)b(c)d").equals("ab(c)d");
        assert solution.minRemoveToMakeValid("))((").equals("");
    }
}
