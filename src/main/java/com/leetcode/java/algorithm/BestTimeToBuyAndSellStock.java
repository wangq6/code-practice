package com.leetcode.java.algorithm;

public class BestTimeToBuyAndSellStock {
    public static int maxProfitOneTransaction(int[] prices) {
        int maxProfit = 0;
        int curMin = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < curMin) {
                curMin = prices[i];
            }
            if (maxProfit < prices[i] - curMin) {
                maxProfit = prices[i] - curMin;
            }
        }
        return maxProfit;
    }

    public static int maxProfitUnlimitedTransaction(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int pre = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > pre) {
                maxProfit += prices[i] - pre;
            }
            pre = prices[i];
        }
        return maxProfit;
    }

    public static int maxProfitTwoTransaction(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int maxProfit = 0;
        int curMin = prices[0];
        int curMax = prices[n - 1];
        int[] dp = new int[n];

        for (int i = 1; i < prices.length; i++) {
            curMin = Math.min(curMin, prices[i]);
            dp[i] = Math.max(prices[i] - curMin, dp[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            curMax = Math.max(curMax, prices[i]);
            maxProfit = Math.max(dp[i] + curMax - prices[i], maxProfit);
        }

        return maxProfit;
    }

    public static int maxProfitKTransaction(int k, int[] prices) {
        int n = prices.length;
        if (k >= n / 2) {
            return maxProfitUnlimitedTransaction(prices);
        }
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int curMax = -prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(prices[j] + curMax, dp[i][j - 1]);
                curMax = Math.max(dp[i - 1][j - 1] - prices[j], curMax);
            }
        }
        return dp[k][n - 1];
    }
}
