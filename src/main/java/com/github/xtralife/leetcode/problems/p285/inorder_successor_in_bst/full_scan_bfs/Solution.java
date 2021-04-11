package com.github.xtralife.leetcode.problems.p285.inorder_successor_in_bst.full_scan_bfs;

import java.util.LinkedList;

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        var queue = new LinkedList<TreeNode>();
        var res = new TreeNode(Integer.MAX_VALUE);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) continue;
            if (node.val > p.val && node.val < res.val) res = node;
            queue.add(node.left);
            queue.add(node.right);
        }
        return (res.val == Integer.MAX_VALUE) ? null : res;
    }
}
