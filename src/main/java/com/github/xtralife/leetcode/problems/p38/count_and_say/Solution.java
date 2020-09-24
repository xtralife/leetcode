package com.github.xtralife.leetcode.problems.p38.count_and_say;

public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return say(countAndSay(n - 1));
    }

    private String say(String str) {
        StringBuilder builder = new StringBuilder();
        char current = 'z';
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == current) {
                count++;
            } else {
                if (current != 'z') {
                    builder.append(count).append(current);
                }
                current = c;
                count = 1;
            }
        }
        return builder.append(count).append(current).toString();
    }
}
