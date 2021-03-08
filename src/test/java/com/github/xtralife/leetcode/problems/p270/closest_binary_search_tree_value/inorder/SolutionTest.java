package com.github.xtralife.leetcode.problems.p270.closest_binary_search_tree_value.inorder;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5));
        int result = solution.closestValue(root, 3.714286);
        assert result == 4;
    }
}
