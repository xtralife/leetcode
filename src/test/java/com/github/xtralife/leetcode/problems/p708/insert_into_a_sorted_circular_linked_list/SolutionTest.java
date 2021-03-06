package com.github.xtralife.leetcode.problems.p708.insert_into_a_sorted_circular_linked_list;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        Node node = new Node(1);
        node.next = node;
        solution.insert(node, 0);
        assert node.val == 1;
        assert node.next.val == 0;
    }
}
