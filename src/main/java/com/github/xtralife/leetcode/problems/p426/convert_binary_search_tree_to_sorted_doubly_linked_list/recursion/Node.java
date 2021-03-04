package com.github.xtralife.leetcode.problems.p426.convert_binary_search_tree_to_sorted_doubly_linked_list.recursion;

public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
