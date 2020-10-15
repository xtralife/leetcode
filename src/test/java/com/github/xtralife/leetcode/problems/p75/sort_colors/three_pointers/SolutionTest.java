package com.github.xtralife.leetcode.problems.p75.sort_colors.three_pointers;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 0, 1};
        solution.sortColors(nums);
        assert nums[0] == 0;
        assert nums[1] == 1;
        assert nums[2] == 2;

        nums = new int[]{2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        assert nums[0] == 0;
        assert nums[1] == 0;
        assert nums[2] == 1;
    }
}
