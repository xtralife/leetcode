package com.github.xtralife.leetcode.problems.p1209.remove_all_adjacent_duplicates_in_string_ii;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assert solution.removeDuplicates("deeedbbcccbdaa", 3).equals("aa");
    }
}
