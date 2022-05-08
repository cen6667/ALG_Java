package com_base.dynamic_programming.stock_question.LT_309_maxProfit;

public class Solution {
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];

        // bad case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);

        for (int i = 2; i < prices.length; i++) {
            // dp公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }
    // 一维数组优化
    public int maxProfit(int[] prices) {
        int[] dp=new int[4];

        dp[0] = -prices[0];
        dp[1] = 0;
        for(int i = 1; i <= prices.length; i++){
            // 使用临时变量来保存dp[0], dp[2]
            // 因为马上dp[0]和dp[2]的数据都会变
            int temp = dp[0];
            int temp1 = dp[2];
            dp[0] = Math.max(dp[0], Math.max(dp[3], dp[1]) - prices[i-1]);
            dp[1] = Math.max(dp[1], dp[3]);
            dp[2] = temp + prices[i-1];
            dp[3] = temp1;
        }
        return Math.max(dp[3],Math.max(dp[1],dp[2]));
    }


    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        Solution sl = new Solution();
        System.out.println(sl.maxProfit(nums));
    }
}
