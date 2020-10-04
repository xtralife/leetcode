package com.github.xtralife.leetcode.problems.p269.alien_dictionary;

import java.util.*;

public class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Integer> inCount = new HashMap<>();
        Map<Character, List<Character>> direct = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                inCount.putIfAbsent(ch, 0);
                direct.putIfAbsent(ch, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String currWord = words[i];
            String nextWord = words[i + 1];
            if (currWord.length() > nextWord.length() && currWord.startsWith(nextWord)) {
                return "";
            }
            for (int p = 0; p < Math.min(currWord.length(), nextWord.length()); p++) {
                char currChar = currWord.charAt(p);
                char nextChar = nextWord.charAt(p);
                if (currChar == nextChar) {
                    continue;
                }
                direct.get(currChar).add(nextChar);
                inCount.put(nextChar, inCount.get(nextChar) + 1);
                break;
            }
        }

        StringBuilder builder = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (Character ch : inCount.keySet()) {
            if (inCount.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        while (!queue.isEmpty()) {
            Character free = queue.remove();
            builder.append(free);
            for (Character ch : direct.get(free)) {
                inCount.put(ch, inCount.get(ch) - 1);
                if (inCount.get(ch) == 0) {
                    queue.offer(ch);
                }
            }
        }

        if (builder.length() < inCount.size()) {
            return "";
        }
        return builder.toString();
    }
}
