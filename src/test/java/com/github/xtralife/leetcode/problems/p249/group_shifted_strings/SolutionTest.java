package com.github.xtralife.leetcode.problems.p249.group_shifted_strings;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();

        assert solution.groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}).size() == 4;
    }
}
