package com.github.xtralife.leetcode.problems.p820.short_encoding_of_words.prefixes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }
        return set.stream().mapToInt(String::length).sum() + set.size();
    }
}
