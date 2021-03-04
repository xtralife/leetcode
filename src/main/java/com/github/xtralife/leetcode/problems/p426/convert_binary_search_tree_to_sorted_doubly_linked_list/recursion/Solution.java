package com.github.xtralife.leetcode.problems.p426.convert_binary_search_tree_to_sorted_doubly_linked_list.recursion;

public class Solution {
    private Node first;
    private Node prev;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        transform(root);
        first.left = prev;
        prev.right = first;
        return first;
    }

    private void transform(Node node) {
        if (node.left != null) {
            transform(node.left);
        }
        if (first == null) {
            first = node;
        }
        if (prev != null) {
            prev.right = node;
            node.left = prev;
        }
        prev = node;
        if (node.right != null) {
            transform(node.right);
        }
    }
}
