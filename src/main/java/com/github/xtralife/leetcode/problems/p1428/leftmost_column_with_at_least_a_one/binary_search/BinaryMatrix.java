package com.github.xtralife.leetcode.problems.p1428.leftmost_column_with_at_least_a_one.binary_search;

import java.util.List;

public interface BinaryMatrix {
    int get(int row, int col);

    List<Integer> dimensions();
}