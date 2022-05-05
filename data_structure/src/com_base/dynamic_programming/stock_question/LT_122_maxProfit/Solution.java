package com_base.dynamic_programming.stock_question.LT_122_maxProfit;

public class Solution {
    // 实现1：二维数组存储
    // 可以将每天持有与否的情况分别用 dp[i][0] 和 dp[i][1] 来进行存储
    // 时间复杂度：O(n)，空间复杂度：O(n)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];     // 创建二维数组存储状态
        dp[0][0] = 0;                   // 初始状态
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            // 注意这里是和121. 买卖股票的最佳时机唯一不同的地方。
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);    // 第 i 天，没有股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);    // 第 i 天，持有股票
        }
        return dp[n - 1][0];    // 卖出股票收益高于持有股票收益，因此取[0]
    }

    // 优化空间
    public int maxProfit2(int[] prices) {
        int[] dp = new int[2];
        // 0表示持有，1表示卖出
        dp[0] = -prices[0];
        dp[1] = 0;
        for(int i = 1; i <= prices.length; i++){
            // 前一天持有; 既然不限制交易次数，那么再次买股票时，要加上之前的收益
            dp[0] = Math.max(dp[0], dp[1] - prices[i-1]);// 注意这里是和121. 买卖股票的最佳时机唯一不同的地方。
            // 前一天卖出; 或当天卖出，当天卖出，得先持有
            dp[1] = Math.max(dp[1], dp[0] + prices[i-1]);
        }
        return dp[1];
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        Solution sl = new Solution();
        System.out.println(sl.maxProfit(nums));
    }
}
