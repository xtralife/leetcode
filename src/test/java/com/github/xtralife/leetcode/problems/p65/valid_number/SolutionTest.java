package com.github.xtralife.leetcode.problems.p65.valid_number;

import com.github.xtralife.leetcode.problems.p65.valid_number.state_machine.Solution;
import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assert solution.isNumber("1 ");
    }
}
