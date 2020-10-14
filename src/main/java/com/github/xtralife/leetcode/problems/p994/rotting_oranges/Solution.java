package com.github.xtralife.leetcode.problems.p994.rotting_oranges;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<List<Integer>> queue = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(Arrays.asList(i, j));
                }
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int minutes = 0;
        while (!queue.isEmpty()) {
            if (freshCount == 0) {
                return minutes;
            }
            minutes++;
            int rotten = queue.size();
            for (int i = 0; i < rotten; i++) {
                List<Integer> elem = queue.poll();
                int row = elem.get(0);
                int col = elem.get(1);
                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    freshCount--;
                    queue.add(Arrays.asList(row - 1, col));
                }
                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    freshCount--;
                    queue.add(Arrays.asList(row, col - 1));
                }
                if (row + 1 < grid.length && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    freshCount--;
                    queue.add(Arrays.asList(row + 1, col));
                }
                if (col + 1 < grid[0].length && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    freshCount--;
                    queue.add(Arrays.asList(row, col + 1));
                }
            }
        }
        if (freshCount > 0) {
            return -1;
        }
        return minutes;
    }
}
