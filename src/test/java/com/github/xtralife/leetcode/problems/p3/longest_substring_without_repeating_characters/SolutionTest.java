package com.github.xtralife.leetcode.problems.p3.longest_substring_without_repeating_characters;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assert solution.lengthOfLongestSubstring("pwwkew") == 3;
    }

}
