package com.github.xtralife.leetcode.problems.p128.longest_consecutive_sequence;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assert solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}) == 4;
        assert solution.longestConsecutive(new int[]{-1, 1, 0}) == 3;
        assert solution.longestConsecutive(new int[]{1, 2, 0, 1}) == 3;
    }
}
