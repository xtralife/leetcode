package com.github.xtralife.leetcode.problems.p938.range_sum_of_bst;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

/*
Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32
     10
    5  15
  3  7   18
= 7 + 10 + 15 = 32

dfs:

10: 3 + 5 + 7 + 10 + right

 */

public class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        return dfs(root, L, R);
    }

    private int dfs(TreeNode node, int L, int R) {
        if (node == null) {
            return 0;
        }
        int left = node.val > L ? dfs(node.left, L, R) : 0;
        int curr = node.val >= L && node.val <= R ? node.val : 0;
        int right = node.val < R ? dfs(node.right, L, R) : 0;
        return left + curr + right;
    }
}
