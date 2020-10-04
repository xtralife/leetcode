package com.github.xtralife.leetcode.problems.p140.word_break_ii.dp_bottom_up;

import java.util.*;
import java.util.stream.Collectors;

// LTE on LeetCode
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);

        List<List<List<String>>> memo = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) {
            memo.add(new ArrayList<>());
        }
        memo.get(0).add(new ArrayList<>());

        for (int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                String word = s.substring(start, end);
                if (!dict.contains(word)) {
                    continue;
                }
                List<List<String>> prefixWordBreak = memo.get(start);
                for (List<String> preList : prefixWordBreak) {
                    List<String> lst = new ArrayList<>(preList);
                    lst.add(word);
                    memo.get(end).add(lst);
                }
            }
        }
        return convert(memo.get(s.length()));
    }

    private List<String> convert(List<List<String>> lists) {
        return lists.stream().map(lst -> String.join(" ", lst)).collect(Collectors.toList());
    }
}
