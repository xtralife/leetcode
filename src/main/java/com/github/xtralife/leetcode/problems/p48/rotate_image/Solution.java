package com.github.xtralife.leetcode.problems.p48.rotate_image;

public class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int passes = length / 2;
        for (int i = 0; i < passes; i++) {
            int cells = length - i * 2 - 1;
            for (int j = i; j < cells + i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = temp;
            }
        }
    }
}