package com.github.xtralife.leetcode.problems.p282.expression_add_operators;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();

        assert solution.addOperators("123", 6).containsAll(Arrays.asList("1+2+3", "1*2*3"));
        List<String> result = solution.addOperators("1000000009", 9);
        System.out.println(result);
    }
}
