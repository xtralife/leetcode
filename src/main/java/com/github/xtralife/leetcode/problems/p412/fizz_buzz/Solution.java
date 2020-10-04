package com.github.xtralife.leetcode.problems.p412.fizz_buzz;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private final static String FIZZ = "Fizz";
    private final static String BUZZ = "Buzz";

    public List<String> fizzBuzz(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(num -> {
                    if (num % 15 == 0) {
                        return FIZZ + BUZZ;
                    }
                    if (num % 3 == 0) {
                        return FIZZ;
                    }
                    if (num % 5 == 0) {
                        return BUZZ;
                    }
                    return Integer.toString(num);
                })
                .collect(Collectors.toList());
    }
}
