package com.github.xtralife.leetcode.problems.p102.binary_tree_level_order_traversal.recursively;

import java.util.ArrayList;
import java.util.List;
/*
    3
   / \
  9  20
    /  \
   15   7


result: [[3], [9, 20], [15, 7]]

 */

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(result, root, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, TreeNode node, int level) {
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        if (node.left != null) {
            helper(result, node.left, level + 1);
        }
        if (node.right != null) {
            helper(result, node.right, level + 1);
        }
    }
}
