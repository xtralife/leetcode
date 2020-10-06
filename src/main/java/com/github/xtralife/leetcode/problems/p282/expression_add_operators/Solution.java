package com.github.xtralife.leetcode.problems.p282.expression_add_operators;

import java.util.*;

/*
Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"]

gar:
current:

1 -> a: 0, m: 1
1+2 -> a: 1, m: 2
1-2 -> a: 1, m: -2
1*2 -> a: 0, m: 2
1+2+3 -> a: 3, m: 3
1+2-3 -> a: 3, m: -3
1+2*3 -> a: 1, m: 6
1-2+3 -> a: -1, m: 3
1-2-3 -> a: -1, m: -3
1-2*3 -> a: 1, m: -6

+: a += m, m = value
-: a += m, m = -value
*: a = a, m *= value

-1 -> [concat: 0, 1; add: 1; mult: 0, 1]
2 -> [concat: 0, 12; add: 12; mult: 0, 12] - //12
//12*3*3

*/

public class Solution {
    private static final char plus = '+';
    private static final char minus = '-';
    private static final char multiply = '*';
    private static final String noop = "";

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num.length() == 0) {
            return result;
        }
        recurse(num, 1, num.substring(0, 1), result, target);
        return result;
    }

    private void recurse(String num, int index, String expr, List<String> result, int target) {
        if (index == num.length()) {
            if (isValid(expr, target)) {
                result.add(expr);
            }
            return;
        }

        recurse(num, index + 1, expr + plus + num.charAt(index), result, target);
        recurse(num, index + 1, expr + minus + num.charAt(index), result, target);
        recurse(num, index + 1, expr + multiply + num.charAt(index), result, target);
        recurse(num, index + 1, expr + noop + num.charAt(index), result, target);
    }

    private boolean isValid(String expr, int target) {
        // 1+2*3-4*5
        // +: [1, 2*3-4*5]
        // -: [ [1], [[2*3], [4*5]]]
        // *: [ [[1]], [[[2], [3]], [[4], [5]]]]
        String[] additions = expr.split("\\+");
        long result = 0;
        for (String addition : additions) {
            String[] substractions = addition.split("-");
            long subRes = 0;
            for (int i = 0; i < substractions.length; i++) {
                String[] mults = substractions[i].split("\\*");
                long multRes = 1;
                for (String mult : mults) {
                    if (mult.startsWith("0") && mult.length() > 1) {
                        return false;
                    }
                    multRes *= Long.parseLong(mult);
                }
                if (i == 0) {
                    subRes += multRes;
                } else {
                    subRes -= multRes;
                }
            }
            result += subRes;
        }
        return result == target;
    }
}
