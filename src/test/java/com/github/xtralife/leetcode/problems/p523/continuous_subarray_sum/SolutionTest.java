package com.github.xtralife.leetcode.problems.p523.continuous_subarray_sum;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] arr = {23, 2, 6, 2, 5};
        assert !solution.checkSubarraySum(arr, 6);

        arr = new int[]{0, 0};
        assert solution.checkSubarraySum(arr, -1);

        arr = new int[]{1, 0};
        assert !solution.checkSubarraySum(arr, 2);

        arr = new int[]{1, 1};
        assert solution.checkSubarraySum(arr, 2);

        arr = new int[]{2, 4, 3};
        assert solution.checkSubarraySum(arr, 6);
    }
}
