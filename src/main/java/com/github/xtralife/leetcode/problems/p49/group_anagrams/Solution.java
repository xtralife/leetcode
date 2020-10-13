package com.github.xtralife.leetcode.problems.p49.group_anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            String key = encode(str);
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(str);
        }
        return new ArrayList<>(groups.values());
    }

    private String encode(String str) {
        int[] counts = new int[26];
        for (char ch : str.toCharArray()) {
            counts[ch - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int count : counts) {
            builder.append(count).append(".");
        }
        return builder.toString();
    }
}
