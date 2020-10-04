package com.github.xtralife.leetcode.problems.p680.valid_palindrome_ii;

public class Solution {
    public boolean validPalindrome(String s) {
        return isValidPalindrome(s, 0, s.length() - 1, 1);
    }

    private boolean isValidPalindrome(String s, int start, int end, int tries) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else if (tries > 0) {
                return isValidPalindrome(s, start + 1, end, tries - 1)
                        || isValidPalindrome(s, start, end - 1, tries - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
