package com.github.xtralife.leetcode.problems.p1428.leftmost_column_with_at_least_a_one.left_and_down;

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
            while (binaryMatrix.get(row, result - 1) == 1) {
                result--;
                if (result == 0) {
                    return 0;
                }
            }
        }
        return result == columns ? -1 : result;
    }
}
