package com_base.dynamic_programming.stock_question.LT_714_maxProfit;
//基本同122
public class Solution {
    /**
     * 卖出时支付手续费
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit1(int[] prices, int fee) {
        int len = prices.length;
        // 0 : 持股（买入）
        // 1 : 不持股（售出）
        // dp 定义第i天持股/不持股 所得最多现金
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    /**
     * 买入时支付手续费
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit2(int[] prices, int fee) {
        int len = prices.length;
        // 0 : 持股（买入）
        // 1 : 不持股（售出）
        // dp 定义第i天持股/不持股 所得最多现金
        int[][] dp = new int[len][2];
        // 考虑买入的时候就支付手续费
        dp[0][0] = -prices[0] - fee;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    public int maxProfit(int[] prices, int fee) {
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i <= prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] - prices[i - 1]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i - 1] - fee);
        }
        return dp[1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        Solution sl = new Solution();
        System.out.println(sl.maxProfit(nums, fee));
    }
}
