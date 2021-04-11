package com.github.xtralife.leetcode.problems.p1302.deepest_leaves_sum;

import java.util.LinkedList;

public class Solution {
    public int deepestLeavesSum(TreeNode root) {
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            sum = 0;
            for (int i = 0; i < size; i++) {
                var node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return sum;
    }
}
