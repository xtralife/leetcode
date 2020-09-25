package com.github.xtralife.leetcode.problems.p108.convert_sorted_array_to_binary_search_tree;

import sun.reflect.generics.tree.Tree;

/*
nums: [-10,-3,0,5,9]

helper: 0, 5
middle: 2
node: 0
node.left: -3 (-10)
node.right: 9 (5)
     0
  -3  9
 -10 5
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        if (end - start == 1) {
            new TreeNode(nums[start]);
        }
        int middle = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = helper(nums, start, middle);
        if (middle < end) {
            node.right = helper(nums, middle + 1, end);
        }
        return node;
    }
}
