package com.github.xtralife.leetcode.problems.p412.fizz_buzz.hash_map;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private final Map<Integer, String> words;

    {
        words = new LinkedHashMap<>(2);
        words.put(3, "Fizz");
        words.put(5, "Buzz");
    }

    public List<String> fizzBuzz(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(num -> {
                    String result = "";
                    for (Integer key : words.keySet()) {
                        if (num % key == 0) {
                            result += words.get(key);
                        }
                    }
                    return result.isEmpty() ? Integer.toString(num) : result;
                })
                .collect(Collectors.toList());
    }
}