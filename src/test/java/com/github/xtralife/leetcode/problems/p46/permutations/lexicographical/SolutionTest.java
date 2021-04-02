package com.github.xtralife.leetcode.problems.p46.permutations.lexicographical;

import org.testng.annotations.Test;

import java.util.List;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.permute(new int[] {2, 1, 3});
        assert result.size() == 9;
    }
}
