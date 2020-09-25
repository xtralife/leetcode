package com.github.xtralife.leetcode.problems.p98.validate_binary_search_tree.recursively;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(1), null);
        assert !solution.isValidBST(root);

        root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        assert solution.isValidBST(root);

        root = new TreeNode(10, new TreeNode(5), new TreeNode(15, new TreeNode(6), new TreeNode(20)));
        assert !solution.isValidBST(root);
    }
}
