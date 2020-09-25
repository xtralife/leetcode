package com.github.xtralife.leetcode.problems.p108.convert_sorted_array_to_binary_search_tree.left_middle;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = helper(nums, start, middle - 1);
        node.right = helper(nums, middle + 1, end);
        return node;
    }
}
