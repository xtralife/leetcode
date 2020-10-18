package com.github.xtralife.leetcode.problems.p417.pacific_atlantic_water_flow;

import java.util.*;

public class Solution {
    private final static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        Queue<List<Integer>> pacific = fillQueue(matrix, 0, 0);
        Set<List<Integer>> pacSet = flow(pacific, matrix);

        Queue<List<Integer>> atlantic = fillQueue(matrix, matrix.length - 1, matrix[0].length - 1);
        Set<List<Integer>> atlSet = flow(atlantic, matrix);

        pacSet.retainAll(atlSet);
        return new ArrayList<>(pacSet);
    }

    private Queue<List<Integer>> fillQueue(int[][] matrix, int row, int column) {
        Queue<List<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            queue.add(Arrays.asList(row, i));
        }
        for (int i = 0; i < matrix.length; i++) {
            queue.add(Arrays.asList(i, column));
        }
        return queue;
    }

    private List<Integer> getLocation(List<Integer> loc, int[] direction) {
        return Arrays.asList(loc.get(0) + direction[0], loc.get(1) + direction[1]);
    }

    private boolean canFlowFrom(List<Integer> from, List<Integer> to, int[][] matrix, Set<List<Integer>> visited) {
        int fromRow = from.get(0);
        int fromCol = from.get(1);
        if (fromRow < 0 || fromRow >= matrix.length || fromCol < 0 || fromCol >= matrix[0].length) {
            return false;
        }
        if (visited.contains(from)) {
            return false;
        }
        return matrix[fromRow][fromCol] >= matrix[to.get(0)][to.get(1)];
    }

    private Set<List<Integer>> flow(Queue<List<Integer>> cells, int[][] matrix) {
        Set<List<Integer>> res = new HashSet<>();

        while (!cells.isEmpty()) {
            List<Integer> loc = cells.poll();
            res.add(loc);
            for (int[] direction : directions) {
                List<Integer> newLoc = getLocation(loc, direction);
                if (canFlowFrom(newLoc, loc, matrix, res)) {
                    cells.add(newLoc);
                }
            }
        }

        return res;
    }
}
