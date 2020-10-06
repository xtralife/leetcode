package com.github.xtralife.leetcode.problems.p282.expression_add_operators.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();

        assert solution.addOperators("123", 6).containsAll(Arrays.asList("1+2+3", "1*2*3"));
        assert solution.addOperators("1000000009", 9).size() == 2000;
    }
}
