package com.github.xtralife.leetcode.problems.p1704.determine_if_string_halves_are_alike;

import java.util.Set;

public class Solution {
    private Set<Character> vowels = Set.of('a', 'e', 'o', 'i', 'u', 'A', 'E', 'O', 'I', 'U');
    public boolean halvesAreAlike(String s) {
        int half = s.length() / 2;
        int pointer = 0;
        int first = 0;
        int second = 0;
        while (pointer < half) {
            if (vowels.contains(s.charAt(pointer))) first++;
            if (vowels.contains(s.charAt(pointer + half))) second++;
            pointer++;
        }
        return first == second;
    }
}
