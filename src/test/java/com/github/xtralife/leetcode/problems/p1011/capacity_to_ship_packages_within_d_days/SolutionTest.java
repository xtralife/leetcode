package com.github.xtralife.leetcode.problems.p1011.capacity_to_ship_packages_within_d_days;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int result = solution.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
        assert result == 15;
    }
}
