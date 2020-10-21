package com.github.xtralife.leetcode.problems.p5.longest_palindromic_substring;

public class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int length = Math.max(expand(s, i, i), expand(s, i, i + 1));
            if (end - start < length) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String s, int start, int end) {
        int left = start;
        int right = end;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
