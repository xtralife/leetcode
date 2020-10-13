package com.github.xtralife.leetcode.problems.p49.group_anagrams;

import org.testng.annotations.Test;

import java.util.List;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        List<List<String>> result = solution.groupAnagrams(new String[]{"bdddddddddd", "bbbbbbbbbbc"});
        assert result.size() == 2;
    }
}
