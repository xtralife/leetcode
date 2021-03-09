package com.github.xtralife.leetcode.problems.p236.lowest_common_ancestor_of_a_binary_tree.stack;

import java.util.Stack;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = buildStack(root, p);
        Stack<TreeNode> qStack = buildStack(root, q);
        int minSize = Math.min(pStack.size(), qStack.size());
        Stack<TreeNode> longer = pStack.size() > minSize ? pStack : qStack;
        while (longer.size() > minSize) {
            longer.pop();
        }
        while (pStack.peek() != qStack.peek()) {
            pStack.pop();
            qStack.pop();
        }
        return pStack.peek();
    }

    private Stack<TreeNode> buildStack(TreeNode root, TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        buildStack(stack, node);
        return stack;
    }

    private void buildStack(Stack<TreeNode> stack, TreeNode node) {
        TreeNode top = stack.peek();
        if (top == node) {
            return;
        }
        if (top.left != null) {
            stack.push(top.left);
            buildStack(stack, node);
            if (stack.peek() == node) {
                return;
            }
            stack.pop();
        }
        if (top.right != null) {
            stack.push(top.right);
            buildStack(stack, node);
            if (stack.peek() == node) {
                return;
            }
            stack.pop();
        }
    }
}
