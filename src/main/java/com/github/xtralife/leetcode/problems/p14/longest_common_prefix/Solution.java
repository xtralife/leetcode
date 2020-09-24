package com.github.xtralife.leetcode.problems.p14.longest_common_prefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].isEmpty()) {
            return "";
        }
        int index = 0;

        out:
        do {
            char ch = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() == index || strs[i].charAt(index) != ch) {
                    break out;
                }
            }
        } while (++index < strs[0].length());
        return strs[0].substring(0, index);
    }
}
