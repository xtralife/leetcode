package com.github.xtralife.leetcode.problems.p118.pascal_triangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        result.add(Collections.singletonList(1));
        for (int i = 2; i <= numRows; i++) {
            addNew(result);
        }
        return result;
    }

    private void addNew(List<List<Integer>> list) {
        List<Integer> row = new ArrayList<>();
        List<Integer> prevRow = list.get(list.size() - 1);
        row.add(1);
        for (int i = 0; i < prevRow.size() - 1; i++) {
            row.add(prevRow.get(i) + prevRow.get(i + 1));
        }
        row.add(1);
        list.add(row);
    }
}
