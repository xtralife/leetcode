package com.github.xtralife.leetcode.problems.p36.valid_sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int size = board.length;
        List<Set<Character>> rows = new ArrayList<>(size);
        IntStream.range(0, size).forEach(i -> rows.add(new HashSet<>()));
        List<Set<Character>> columns = new ArrayList<>(size);
        IntStream.range(0, size).forEach(i -> columns.add(new HashSet<>()));
        List<Set<Character>> blocks = new ArrayList<>(size);
        IntStream.range(0, size).forEach(i -> blocks.add(new HashSet<>()));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                char value = board[i][j];
                if (value == '.') {
                    continue;
                }

                Set<Character> row = rows.get(i);
                if (row.contains(value)) {
                    return false;
                }
                Set<Character> column = columns.get(j);
                if (column.contains(value)) {
                    return false;
                }
                Set<Character> block = blocks.get((i / 3) * 3 + j / 3);
                if (block.contains(value)) {
                    return false;
                }
                row.add(value);
                column.add(value);
                block.add(value);
            }
        }
        return true;
    }
}
