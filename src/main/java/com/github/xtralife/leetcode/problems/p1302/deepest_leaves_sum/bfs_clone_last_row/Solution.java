package com.github.xtralife.leetcode.problems.p1302.deepest_leaves_sum.bfs_clone_last_row;

import java.util.LinkedList;

public class Solution {
    public int deepestLeavesSum(TreeNode root) {
        LinkedList<TreeNode> row = new LinkedList<>();
        row.add(root);
        var lastRow = new LinkedList<TreeNode>();
        while (!row.isEmpty()) {
            lastRow = (LinkedList<TreeNode>) row.clone();
            int size = row.size();
            for (int i = 0; i < size; i++) {
                var node = row.poll();
                if (node.left != null) row.add(node.left);
                if (node.right != null) row.add(node.right);
            }
        }
        int res = 0;
        for (var node : lastRow) {
            res += node.val;
        }
        return res;
    }
}
