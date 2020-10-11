package com.github.xtralife.leetcode.problems.p859.buddy_strings.optimized;

import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public boolean buddyStrings(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int first = -1;
        int second = -1;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false;
                }
            }
        }
        if (first == -1) {
            return a.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .values().stream().anyMatch(i -> i > 1);
        }
        if (second == -1) {
            return false;
        }
        return (a.charAt(first) == b.charAt(second) && a.charAt(second) == b.charAt(first));
    }
}
