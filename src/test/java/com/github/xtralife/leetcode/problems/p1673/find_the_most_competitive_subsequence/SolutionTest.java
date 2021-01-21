package com.github.xtralife.leetcode.problems.p1673.find_the_most_competitive_subsequence;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] result = solution.mostCompetitive(new int[] {71,18,52,29,55,73,24,42,66,8,80,2}, 3);
        assert result.length == 3;
    }
}
