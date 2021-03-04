package com.github.xtralife.leetcode.problems.p426.convert_binary_search_tree_to_sorted_doubly_linked_list.iteration;

import java.util.Stack;

public class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node first = null;
        Node prev = null;
        while (!stack.isEmpty()) {
            if (stack.peek().left != null) {
                Node node = stack.peek().left;
                stack.peek().left = null;
                stack.push(node);
                continue;
            }
            Node node = stack.pop();
            if (first == null) {
                first = node;
            }
            if (prev != null) {
                prev.right = node;
                node.left = prev;
            }
            prev = node;
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        first.left = prev;
        prev.right = first;
        return first;
    }
}
