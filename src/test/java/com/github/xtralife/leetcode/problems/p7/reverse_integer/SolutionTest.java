package com.github.xtralife.leetcode.problems.p7.reverse_integer;


import org.testng.annotations.Test;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution();

        assert solution.reverse(123) == 321;
        assert solution.reverse(-123) == -321;
        assert solution.reverse(1534236469) == 0;
    }
}
