package com.github.xtralife.leetcode.problems.p322.coin_change;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new int[amount + 1]);
    }

    private int coinChange(int[] coins, int amount, int[] track) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (track[amount] != 0) {
            return track[amount];
        }
        int minCount = -1;
        for (int coin : coins) {
            int prevCount = coinChange(coins, amount - coin, track);
            if (prevCount == -1) {
                continue;
            }
            if (minCount == -1) {
                minCount = prevCount + 1;
            } else {
                minCount = Math.min(minCount, prevCount + 1);
            }
        }
        track[amount] = minCount;
        return minCount;
    }
}
