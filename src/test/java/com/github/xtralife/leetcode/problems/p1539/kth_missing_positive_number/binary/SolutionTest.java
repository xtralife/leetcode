package com.github.xtralife.leetcode.problems.p1539.kth_missing_positive_number.binary;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int result = solution.findKthPositive(new int[]{1, 3, 5, 8}, 2);
        assert result == 4;
        result = solution.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5);
        assert result == 9;
        result = solution.findKthPositive(new int[]{1, 2, 3, 4}, 2);
        assert result == 6;

        com.github.xtralife.leetcode.problems.p1539.kth_missing_positive_number.binary_leetode.Solution solution2 = new com.github.xtralife.leetcode.problems.p1539.kth_missing_positive_number.binary_leetode.Solution();
        result = solution2.findKthPositive(new int[]{1, 3, 5, 8}, 2);
        assert result == 4;

    }
}
