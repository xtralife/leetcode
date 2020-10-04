package com.github.xtralife.leetcode.problems.p269.alien_dictionary;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        String result = solution.alienOrder(words);
        assert result.equals("wertf");
    }
}
