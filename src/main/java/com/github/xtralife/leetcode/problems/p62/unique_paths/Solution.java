package com.github.xtralife.leetcode.problems.p62.unique_paths;

import java.util.Arrays;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for (int[] arr : paths) {
            Arrays.fill(arr, 1);
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                paths[row][col] = paths[row - 1][col] + paths[row][col - 1];
            }
        }
        return paths[m - 1][n - 1];
    }
}
