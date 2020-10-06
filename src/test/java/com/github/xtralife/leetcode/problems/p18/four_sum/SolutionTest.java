package com.github.xtralife.leetcode.problems.p18.four_sum;

import org.testng.annotations.Test;

import java.util.List;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.fourSum(new int[]{0, 0, 0, 0}, 0);
        assert result.size() == 1;

        result = solution.fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11);
        assert result.size() == 1;
    }
}
