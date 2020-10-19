package com.github.xtralife.leetcode.problems.p187.repeated_dna_sequences.hash;

import java.util.*;

public class Solution {
    private final static Map<Character, Integer> toInt = new HashMap<>();

    static {
        toInt.put('A', 0);
        toInt.put('C', 1);
        toInt.put('G', 2);
        toInt.put('T', 3);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }
        int base = 4; // 2 ^ 2
        int topBase = base << 18; //4^10 == 2^20 == 1 << 20 == 1 << 2 << 18 == 4 << 18

        Set<String> res = new HashSet<>();
        int hash = 0;
        for (int i = 0; i < 10; i++) {
            hash *= base;
            hash += toInt.get(s.charAt(i));
        }
        Set<Integer> seen = new HashSet<>();
        seen.add(hash);
        for (int i = 10; i < s.length(); i++) {
            hash *= base;
            hash %= topBase;
            hash += toInt.get(s.charAt(i));
            if (seen.contains(hash)) {
                res.add(s.substring(i - 9, i + 1));
            } else {
                seen.add(hash);
            }
        }
        return new ArrayList<>(res);
    }
}
