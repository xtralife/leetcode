package com.github.xtralife.leetcode.problems.p55.jump_game;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assert solution.canJump(new int[]{2, 3, 1, 1, 4});
    }
}
