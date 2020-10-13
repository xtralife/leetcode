package com.github.xtralife.leetcode.problems.p54.spiral_matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        for (int i = 0; i < maxRounds(matrix); i++) {
            addRound(matrix, i, result);
        }
        return result;
    }

    private void addRound(int[][] matrix, int round, List<Integer> result) {
        for (int i = round; i < matrix[0].length - round; i++) {
            result.add(matrix[round][i]);
        }
        for (int i = round + 1; i < matrix.length - round; i++) {
            result.add(matrix[i][matrix[0].length - round - 1]);
        }
        if (matrix.length / 2 > round) {
            for (int i = matrix[0].length - round - 2; i >= round; i--) {
                result.add(matrix[matrix.length - round - 1][i]);
            }
        } else {
            return;
        }
        if (matrix[0].length / 2 > round) {
            for (int i = matrix.length - round - 2; i > round; i--) {
                result.add(matrix[i][round]);
            }
        }
    }

    private int maxRounds(int[][] matrix) {
        return (Math.min(matrix.length, matrix[0].length) + 1) / 2;
    }
}
