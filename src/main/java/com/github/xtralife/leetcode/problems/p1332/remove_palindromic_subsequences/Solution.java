package com.github.xtralife.leetcode.problems.p1332.remove_palindromic_subsequences;

public class Solution {
    public int removePalindromeSub(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        return 2 - isPalindrome(s);
    }

    private int isPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            if (s.charAt(head++) != s.charAt(tail--)) {
                return 0;
            }
        }
        return 1;
    }
}
