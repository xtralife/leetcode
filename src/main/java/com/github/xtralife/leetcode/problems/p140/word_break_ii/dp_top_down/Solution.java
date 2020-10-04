package com.github.xtralife.leetcode.problems.p140.word_break_ii.dp_top_down;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, List<List<String>>> memo = new HashMap<>();
        List<List<String>> empty = new ArrayList<>();
        empty.add(new ArrayList<>());
        memo.put("", empty);

        topDownWordBreak(s, dict, memo);
        return convert(memo.get(s));
    }

    private List<String> convert(List<List<String>> lists) {
        return lists.stream().map(lst -> String.join(" ", lst)).collect(Collectors.toList());
    }

    private void topDownWordBreak(String s, Set<String> dict, Map<String, List<List<String>>> memo) {
        if (s.isEmpty()) {
            return;
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            String word = s.substring(0, i);
            if (!dict.contains(word)) {
                continue;
            }
            String postfix = s.substring(i);
            if (!memo.containsKey(postfix)) {
                topDownWordBreak(postfix, dict, memo);
            }
            List<List<String>> postfixWordBreak = memo.get(postfix);
            for (List<String> postfixLst : postfixWordBreak) {
                List<String> lst = new ArrayList<>();
                lst.add(word);
                lst.addAll(postfixLst);
                result.add(lst);
            }
        }
        memo.put(s, result);
    }
}
