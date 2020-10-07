package com.github.xtralife.leetcode.problems.p636.exclusive_time_of_functions;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        List<String> logs = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");
        int[] result = solution.exclusiveTime(2, logs);
        assert result.length == 2;
        assert result[0] == 3;
        assert result[1] == 4;

        logs = Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7");
        result = solution.exclusiveTime(1, logs);
        assert result.length == 1;
        assert result[0] == 8;

        logs = Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7");
        result = solution.exclusiveTime(2, logs);
        assert result.length == 2;
        assert result[0] == 7;
        assert result[1] == 1;

        logs = Arrays.asList("0:start:0", "0:end:0", "1:start:1", "1:end:1", "2:start:2", "2:end:2", "2:start:3", "2:end:3");
        result = solution.exclusiveTime(3, logs);
        assert result.length == 3;
        assert result[0] == 1;
        assert result[1] == 1;
        assert result[2] == 2;
    }
}