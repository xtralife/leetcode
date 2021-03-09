package com.github.xtralife.leetcode.problems.p623.add_new_row_to_tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            return new TreeNode(v, root, null);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curr = 2;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (curr < d) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                curr++;
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    node.left = new TreeNode(v, node.left, null);
                    node.right = new TreeNode(v, null, node.right);
                }
                break;
            }
        }
        return root;
    }
}
