package com.github.xtralife.leetcode.problems.p65.valid_number.rexexp;

import java.util.regex.Pattern;

public class Solution {
    public boolean isNumber(String s) {
        return Pattern.matches("\\s*[+-]?(\\d+\\.\\d*?|\\d*\\.?\\d+)(e[+-]?\\d+)?\\s*", s);
    }
}
