package com.github.xtralife.leetcode.problems.p1302.deepest_leaves_sum;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + (left != null ? left.val : null) +
                ", right=" + (right != null ? right.val : null) +
                '}';
    }
}