package com.github.xtralife.leetcode.problems.p1743.restore_an_array_from_adjacent_pairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            map.putIfAbsent(pair[0], new ArrayList<>());
            map.putIfAbsent(pair[1], new ArrayList<>());
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
        int current = 0;
        for (int key : map.keySet()) {
            if (map.get(key).size() == 1) {
                current = key;
                break;
            }
        }

        int[] res = new int[adjacentPairs.length + 1];
        int pointer = 0;
        for (int i = 0; i < adjacentPairs.length; i++) {
            res[pointer++] = current;
            int next = map.get(current).get(0);
            map.remove(current);
            map.get(next).remove(Integer.valueOf(current));
            current = next;
        }
        res[pointer] = current;
        return res;
    }
}
