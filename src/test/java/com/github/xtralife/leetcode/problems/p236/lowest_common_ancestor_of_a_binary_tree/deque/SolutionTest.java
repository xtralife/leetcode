package com.github.xtralife.leetcode.problems.p236.lowest_common_ancestor_of_a_binary_tree.deque;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void solutionTest() {
        Solution solution = new Solution();
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), node4));
        TreeNode root = new TreeNode(3, node5, new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        TreeNode result = solution.lowestCommonAncestor(root, node5, node4);
        assert result.val == 5;
    }
}
