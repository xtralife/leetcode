package com.github.xtralife.leetcode.problems.p122.buy_sell_stock;

public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int dayProfit = prices[i] - prices[i - 1];
            if (dayProfit > 0) {
                profit += dayProfit;
            }
        }
        return profit;
    }
}
