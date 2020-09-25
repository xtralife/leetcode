package com.github.xtralife.leetcode.problems.p98.validate_binary_search_tree.recursively;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        Integer min = null;
        Integer max = null;
        return isValidBST(root, min, max);
    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}