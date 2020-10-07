package com.github.xtralife.leetcode.problems.p636.exclusive_time_of_functions;

import java.util.List;
import java.util.Stack;

public class Solution {
    private static final String splitter = ":";
    private static final String start = "start";

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] exclusiveTimes = new int[n];
        Stack<Integer> ids = new Stack<>();
        String[] logDetails;
        int time = 0;
        for (String log : logs) {
            logDetails = log.split(splitter);
            int timestamp = Integer.parseInt(logDetails[2]);
            if (logDetails[1].equals(start)) {
                if (timestamp > time) {
                    exclusiveTimes[ids.peek()] += timestamp - time;
                }
                time = timestamp;
                ids.push(Integer.parseInt(logDetails[0]));
            } else {
                exclusiveTimes[ids.pop()] += timestamp - time + 1;
                time = timestamp + 1;
            }
        }
        return exclusiveTimes;
    }
}
