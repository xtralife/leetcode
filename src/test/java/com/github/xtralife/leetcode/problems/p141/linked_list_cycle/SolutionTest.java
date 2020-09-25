package com.github.xtralife.leetcode.problems.p141.linked_list_cycle;

import com.github.xtralife.leetcode.problems.p141.linked_list_cycle.brent.ListNode;
import com.github.xtralife.leetcode.problems.p141.linked_list_cycle.brent.Solution;
import org.testng.annotations.Test;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        ListNode head = new ListNode(3);
        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(0));
        head.getNext().getNext().setNext(new ListNode(-4));
        head.getNext().getNext().getNext().setNext(head.getNext());

        assert solution.hasCycle(head);
    }

}
