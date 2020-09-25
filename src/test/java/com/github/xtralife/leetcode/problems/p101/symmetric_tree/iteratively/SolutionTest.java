package com.github.xtralife.leetcode.problems.p101.symmetric_tree.iteratively;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        assert solution.isSymmetric(root);

        root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, new TreeNode(3), null));
        assert solution.isSymmetric(root);

        root = new TreeNode(5,
                new TreeNode(4, null, new TreeNode(1, new TreeNode(2), null)),
                new TreeNode(1, null, new TreeNode(4, new TreeNode(2), null)));
        assert !solution.isSymmetric(root);
    }
}
/*
         5
       4   1
        1   4
       2   2
 */

