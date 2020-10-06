package com.github.xtralife.leetcode.problems.p15.three_sum;

import org.testng.annotations.Test;

import java.util.List;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);
        assert result.size() == 2;

        nums = new int[]{0, 0, 0};
        result = solution.threeSum(nums);
        assert result.size() == 1;

        nums = new int[]{3, 0, -2, -1, 1, 2};
        result = solution.threeSum(nums);
        assert result.size() == 3;
    }
}
