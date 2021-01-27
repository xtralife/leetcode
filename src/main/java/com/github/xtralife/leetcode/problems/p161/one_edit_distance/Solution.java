package com.github.xtralife.leetcode.problems.p161.one_edit_distance;

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int sp = 0;
        int tp = 0;
        while (sp < s.length() && tp < t.length() && s.charAt(sp) == t.charAt(tp)) {
            sp++;
            tp++;
        }
        s = s.substring(sp);
        t = t.substring(tp);
        sp = s.length() - 1;
        tp = t.length() - 1;
        while (sp > -1 && tp > -1 && s.charAt(sp) == t.charAt(tp)) {
            sp--;
            tp--;
        }
        s = s.substring(0, sp + 1);
        t = t.substring(0, tp + 1);
        if (s.isEmpty() && t.isEmpty()) {
            return false;
        }
        if (s.length() > 1 || t.length() > 1) {
            return false;
        }
        if (s.isEmpty() || t.isEmpty()) {
            return true;
        }
        return !s.equals(t);
    }
}
