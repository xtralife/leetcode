package com.github.xtralife.leetcode.problems.p340.longest_substring_with_at_most_k_distinct_characters;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int result = solution.lengthOfLongestSubstringKDistinct("eceba", 2);
        assert result == 3;
    }
}
