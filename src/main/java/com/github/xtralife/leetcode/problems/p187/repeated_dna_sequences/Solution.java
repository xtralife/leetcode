package com.github.xtralife.leetcode.problems.p187.repeated_dna_sequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        if (s.isEmpty() || s.length() < 10) {
            return new ArrayList<>();
        }
        StringBuilder sb = new StringBuilder();
        Set<String> seq = new HashSet<>();
        sb.append(s, 0, 10);
        seq.add(sb.toString());
        for (int i = 10; i < s.length(); i++) {
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            String str = sb.toString();
            if (seq.contains(str)) {
                res.add(str);
            } else {
                seq.add(str);
            }
        }
        return new ArrayList<>(res);
    }
}
