package com.github.xtralife.leetcode.problems.p28.implement_strstr;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.isEmpty()) {
            return -1;
        }
        int hIndex = 0;
        int hCurrentIndex = 0;
        int nCurrentIndex = 0;
        while (hIndex <= haystack.length() - needle.length()) {
            if (nCurrentIndex == needle.length()) {
                return hIndex;
            }
            if (haystack.charAt(hCurrentIndex) == needle.charAt(nCurrentIndex)) {
                hCurrentIndex++;
                nCurrentIndex++;
            } else {
                hCurrentIndex = ++hIndex;
                nCurrentIndex = 0;
            }
        }
        return -1;
    }
}