package com.github.xtralife.leetcode.problems.p54.spiral_matrix;

import org.testng.annotations.Test;

import java.util.List;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {4, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> result = solution.spiralOrder(matrix);
        assert result.size() == 12;

        result = solution.spiralOrder(new int[][]{{6, 9, 7}});
        assert result.size() == 12;
    }
}
