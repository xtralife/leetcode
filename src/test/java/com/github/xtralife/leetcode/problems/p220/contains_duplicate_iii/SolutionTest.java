package com.github.xtralife.leetcode.problems.p220.contains_duplicate_iii;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assert !solution.containsNearbyAlmostDuplicate(new int[]{1, 2}, 0, 1);
    }
}
