package com.github.xtralife.leetcode.problems.p560.subarray_sum_equals_k;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();

        int result = solution.subarraySum(new int[]{7,-7,7,7,7,7,7}, 7);
        System.out.println(result);
    }
}
