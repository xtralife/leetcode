package com.github.xtralife.leetcode.problems.p1428.leftmost_column_with_at_least_a_one.binary_search;

import java.util.List;

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 * public int get(int row, int col) {}
 * public List<Integer> dimensions {}
 * };
 */

public class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0);
        int columns = dimensions.get(1);
        int result = columns;

        for (int row = 0; row < rows; row++) {
            result = Math.min(result, findColumn(binaryMatrix, row, 0, result - 1));
        }
        if (result == columns) {
            return -1;
        }
        return result;
    }

    private int findColumn(BinaryMatrix matrix, int row, int start, int end) {
        if (start > end) {
            return Integer.MAX_VALUE;
        }
        if (start == end) {
            int value = matrix.get(row, start);
            return value == 1 ? start : Integer.MAX_VALUE;
        }
        int middle = start + (end - start) / 2;
        int middleValue = matrix.get(row, middle);
        if (middleValue == 1) {
            return Math.min(middle, findColumn(matrix, row, start, middle - 1));
        }
        return findColumn(matrix, row, middle + 1, end);
    }
}
