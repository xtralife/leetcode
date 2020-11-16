package com.github.xtralife.leetcode.problems.p105.construct_binary_tree_from_preorder_and_inorder_traversal;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, inorder, 0, 0, preorder.length);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int length) {
        if (preStart >= preorder.length || length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        int shift = 0;
        while (inorder[inStart + shift] != preorder[preStart]) {
            shift++;
        }
        node.left = buildTree(preorder, inorder, preStart + 1, inStart, shift);
        node.right = buildTree(preorder, inorder, preStart + shift + 1, inStart + shift + 1, length - shift - 1);
        return node;
    }
}
