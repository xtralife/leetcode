package com.github.xtralife.leetcode.problems.p79.word_search;
/*
1. Create a matrix of visited letters
2. set pointer to current letter = 0;
2. for each cell:
    check if cell coords are valid and cell is not visited
    if (letter in cell == current letter)
        if this is word end return true;
        mark cell as visited
        recurse with pointer+1 to adjacent cells
 */

public class Solution {
    private final static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (findWord(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findWord(char[][] board, int row, int col, String word, int charAt, boolean[][] visited) {
        if (row < 0 || row == board.length || col < 0 || col == board[0].length || visited[row][col]) {
            return false;
        }
        if (word.charAt(charAt) == board[row][col]) {
            if (charAt == word.length() - 1) {
                return true;
            }
            visited[row][col] = true;
            for (int[] direction : directions) {
                if (findWord(board, row + direction[0], col + direction[1], word, charAt + 1, visited)) {
                    return true;
                }
            }
            visited[row][col] = false;
        }
        return false;
    }
}
