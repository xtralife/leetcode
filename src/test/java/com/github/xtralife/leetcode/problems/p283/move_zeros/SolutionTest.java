package com.github.xtralife.leetcode.problems.p283.move_zeros;

import org.testng.annotations.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void testMoveZeros() {
        Solution solution = new Solution();
        int[] input = {0, 1, 2, 0, 3, 4, 0};
        solution.moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }

    @Test
    public void testMoveZerosOneZero() {
        Solution solution = new Solution();
        int[] input = {1, 0};
        solution.moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }
}
