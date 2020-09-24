package com.github.xtralife.leetcode.problems.p125.valid_palindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char sChar = s.charAt(start);
            if (!Character.isLetterOrDigit(sChar)) {
                start++;
                continue;
            }
            char eChar = s.charAt(end);
            if (!Character.isLetterOrDigit(eChar)) {
                end--;
                continue;
            }
            if (sChar != eChar) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
