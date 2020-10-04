package com.github.xtralife.leetcode.problems.p953.verifying_an_alien_dictionary.improved;

import com.google.common.collect.Comparators;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < 26; i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (alienComparator(index).compare(words[i], words[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    private Comparator<String> alienComparator(int[] index) {
        return (s1, s2) -> {
            int length = Math.min(s1.length(), s2.length());
            for (int i = 0; i < length; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    return index[s1.charAt(i) - 'a'] - index[s2.charAt(i) - 'a'];
                }
            }
            return s1.length() - s2.length();
        };
    }
}
