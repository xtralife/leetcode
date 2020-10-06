package com.github.xtralife.leetcode.problems.p124.binary_tree_maximum_path_sum;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assert solution.maxPathSum(root) == 6;
    }

    /*
         5
        / \
       4   8
      /   / \
     11  13  4
     / \      \
    7   2      1

     */
    @Test
    public void testSolution48() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        assert solution.maxPathSum(root) == 48;
    }

    @Test
    public void testSolution35() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(-7)));
        assert solution.maxPathSum(root) == 35;
    }

}
