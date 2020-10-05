package com.github.xtralife.leetcode.problems.p523.continuous_subarray_sum.from_leetcode;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] nums = {0, 0, 0, 0, 0, 0};
        assert solution.checkSubarraySum(nums, 6);

        nums = new int[] {1, 0};
        assert !solution.checkSubarraySum(nums, 2);
    }
}
