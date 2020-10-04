package com.github.xtralife.leetcode.problems.p140.word_break_ii.dp_top_down;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        List<String> dict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        assert solution.wordBreak("catsanddog", dict).containsAll(Arrays.asList("cats and dog", "cat sand dog"));
    }
}
