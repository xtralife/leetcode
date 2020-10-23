package com.github.xtralife.leetcode.problems.p73.set_matrix_zeroes;

import java.util.Arrays;

public class Solution {
    public void setZeroes(int[][] matrix) {
        int colZ = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j == 0) {
                        colZ = 0;
                    } else {
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            Arrays.fill(matrix[0], 0);
        }
        if (colZ == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
