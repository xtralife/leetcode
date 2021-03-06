package com.github.xtralife.leetcode.problems.p31.next_permutation.shorter;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] input = {3, 2, 1};
        solution.nextPermutation(input);
        assert input[0] == 1;
    }
}
