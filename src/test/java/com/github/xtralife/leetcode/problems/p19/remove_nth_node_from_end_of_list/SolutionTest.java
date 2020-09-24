package com.github.xtralife.leetcode.problems.p19.remove_nth_node_from_end_of_list;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        solution.removeNthFromEnd(head, 1);
    }
}
