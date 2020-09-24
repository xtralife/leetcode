package com.github.xtralife.leetcode.problems.p38.count_and_say;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assert solution.countAndSay(4).equals("1211");
    }
}
