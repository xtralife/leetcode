package com.github.xtralife.leetcode.problems.p623.add_new_row_to_tree.dfs;

public class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            return new TreeNode(v, root, null);
        }
        addNewRow(root, v, d, 2);
        return root;
    }

    private void addNewRow(TreeNode node, int value, int depth, int curr) {
        if (curr < depth) {
            if (node.left != null) {
                addNewRow(node.left, value, depth, curr + 1);
            }
            if (node.right != null) {
                addNewRow(node.right, value, depth, curr + 1);
            }
        } else {
            node.left = new TreeNode(value, node.left, null);
            node.right = new TreeNode(value, null, node.right);
        }
    }
}
