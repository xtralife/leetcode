package com.github.xtralife.leetcode.problems.p48.rotate_image;

import org.testng.annotations.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    @Test
    public void testSolution4() {
        Solution solution = new Solution();
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
