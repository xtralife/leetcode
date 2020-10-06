package com.github.xtralife.leetcode.problems.p528.random_pick_with_weight;

import com.github.xtralife.leetcode.problems.p528.random_pick_with_weight.linear_search.Solution;
import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution(new int[]{1, 3, 1});
        solution.pickIndex();
    }
}
