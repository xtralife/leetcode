package com.github.xtralife.leetcode.problems.p438.find_all_anagrams_in_a_string;

import com.github.xtralife.leetcode.problems.p438.find_all_anagrams_in_a_string.sliding_window_hashmap.Solution;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assert solution.findAnagrams("cbaebabacd", "abc").containsAll(Arrays.asList(0, 6));
    }
}
