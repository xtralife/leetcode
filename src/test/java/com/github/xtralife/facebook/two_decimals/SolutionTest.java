package com.github.xtralife.facebook.two_decimals;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        String res = solution.addBigNumbers("3.63", "12.4");
        assert res.length() > 0;
    }
}
