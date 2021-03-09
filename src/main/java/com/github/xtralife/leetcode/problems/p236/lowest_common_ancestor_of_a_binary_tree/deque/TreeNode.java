package com.github.xtralife.leetcode.problems.p236.lowest_common_ancestor_of_a_binary_tree.deque;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + (left == null ? null : left.val) +
                ", right=" + (right == null ? null : right.val) +
                '}';
    }
}
