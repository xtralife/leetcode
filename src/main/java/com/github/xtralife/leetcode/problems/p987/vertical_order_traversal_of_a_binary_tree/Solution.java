package com.github.xtralife.leetcode.problems.p987.vertical_order_traversal_of_a_binary_tree;

import java.util.*;

public class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, TreeMap<Integer, List<Integer>>> memo = new HashMap<>();
        Queue<NodeCoords> queue = new LinkedList<>();
        queue.add(new NodeCoords(root, 0, 0));
        int minCol = 0;
        int maxCol = 0;
        while(!queue.isEmpty()) {
            NodeCoords coords = queue.poll();
            memo.putIfAbsent(coords.col, new TreeMap<>());
            TreeMap<Integer, List<Integer>> colMap = memo.get(coords.col);
            minCol = Math.min(minCol, coords.col);
            maxCol = Math.max(maxCol, coords.col);
            colMap.putIfAbsent(coords.row, new ArrayList<>());
            colMap.get(coords.row).add(coords.node.val);
            if (coords.node.left != null) {
                queue.add(new NodeCoords(coords.node.left, coords.row + 1, coords.col - 1));
            }
            if (coords.node.right != null) {
                queue.add(new NodeCoords(coords.node.right, coords.row + 1, coords.col + 1));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = minCol; i <= maxCol; i++) {
            List<Integer> col = new ArrayList<>();
            for (List<Integer> values : memo.get(i).values()) {
                Collections.sort(values);
                col.addAll(values);
            }
            result.add(col);
        }

        return result;
    }
}
