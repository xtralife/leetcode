package com.github.xtralife.leetcode.problems.p124.binary_tree_maximum_path_sum.naive_sums;

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
public class Solution {
    public int maxPathSum(TreeNode root) {
        long[] sums = new long[2];
        findMaxSum(root, sums);
        return Math.toIntExact(sums[1]);
    }

    private void findMaxSum(TreeNode node, long[] sums) {
        long[] left = new long[2];
        long[] right = new long[2];
        int mid = node.val;
        if (node.left != null) {
            findMaxSum(node.left, left);
        } else {
            left[0] = Integer.MIN_VALUE;
            left[1] = Integer.MIN_VALUE;
        }
        if (node.right != null) {
            findMaxSum(node.right, right);
        } else {
            right[0] = Integer.MIN_VALUE;
            right[1] = Integer.MIN_VALUE;
        }
        sums[0] = max(mid, left[0] + mid, mid + right[0]);
        sums[1] = max(sums[0], left[1], right[1], left[0] + mid + right[0]);
    }

    private long max(long start, long... nums) {
        long result = start;
        for (long num : nums) {
            if (num > result) {
                result = num;
            }
        }
        return result;
    }
}
