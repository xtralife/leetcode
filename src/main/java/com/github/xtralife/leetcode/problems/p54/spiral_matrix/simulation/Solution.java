package com.github.xtralife.leetcode.problems.p54.spiral_matrix.simulation;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        boolean[][] seen = new boolean[matrix.length][matrix[0].length];
        int rowDirection = 0;
        int columnDirection = 1;
        int row = 0;
        int column = -1;
        int visited = 0;
        while (visited < matrix.length * matrix[0].length) {
            if (row + rowDirection < matrix.length && column + columnDirection < matrix[0].length
                    && row + rowDirection >= 0 && column + columnDirection >= 0
                    && !seen[row + rowDirection][column + columnDirection]) {
                row += rowDirection;
                column += columnDirection;
                result.add(matrix[row][column]);
                seen[row][column] = true;
                visited++;
            } else {
                if (rowDirection == 0 && columnDirection == 1) {
                    rowDirection = 1;
                    columnDirection = 0;
                } else if (rowDirection == 1) {
                    rowDirection = 0;
                    columnDirection = -1;
                } else if (rowDirection == 0) {
                    rowDirection = -1;
                    columnDirection = 0;
                } else {
                    rowDirection = 0;
                    columnDirection = 1;
                }
            }
        }
        return result;
    }
}
