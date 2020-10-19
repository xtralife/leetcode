package com.github.xtralife.leetcode.problems.p187.repeated_dna_sequences.bitmask;

import java.util.*;

public class Solution {
    private final static Map<Character, Integer> toInt = new HashMap<>();

    static {
        toInt.put('A', 0b00);
        toInt.put('C', 0b01);
        toInt.put('G', 0b10);
        toInt.put('T', 0b11);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }
        int topBase = 0xFFFFF;

        Set<String> res = new HashSet<>();
        int bitmask = 0;
        for (int i = 0; i < 10; i++) {
            bitmask <<= 2;
            bitmask |= toInt.get(s.charAt(i));
        }

        Set<Integer> seen = new HashSet<>();
        seen.add(bitmask);
        for (int i = 10; i < s.length(); i++) {
            bitmask <<= 2;
            bitmask &= topBase;
            bitmask |= toInt.get(s.charAt(i));
            if (seen.contains(bitmask)) {
                res.add(s.substring(i - 9, i + 1));
            } else {
                seen.add(bitmask);
            }
        }
        return new ArrayList<>(res);
    }
}
