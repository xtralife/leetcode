package com.github.xtralife.leetcode.problems.p322.coin_change.bottom_up;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] track = new int[amount + 1];
        Arrays.fill(track, amount + 1);
        track[0] = 0;
        for (int i = 1; i <= amount ; i++) {
            for (int coin : coins) {
                if (coin > i) {
                    continue;
                }
                track[i] = Math.min(track[i] , track[i - coin] + 1);
            }
        }
        return track[amount] > amount ? -1 : track[amount];
    }
}
