package com.github.xtralife.leetcode.problems.p621.task_scheduler;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        char[] chars = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        assert solution.leastInterval(chars, 2) == 16;
    }
}
