package com.github.xtralife.leetcode.problems.p249.group_shifted_strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String string : strings) {
            String etalon = toEtalon(string);
            groups.putIfAbsent(etalon, new ArrayList<>());
            groups.get(etalon).add(string);
        }
        return new ArrayList<>(groups.values());
    }

    private String toEtalon(String input) {
        if (input.isEmpty()) {
            return input;
        }
        int delta = input.charAt(0) - 'a';
        StringBuilder builder = new StringBuilder();
        for (char ch : input.toCharArray()) {
            int shifted = ch - delta;
            if (shifted < 'a') {
                shifted += 26;
            }
            builder.append((char) shifted);
        }
        return builder.toString();
    }
}
