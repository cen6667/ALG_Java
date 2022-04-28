package com_base.dynamic_programming.knapsack_question.D_CompleteKnapsack.LT_518_change;

public class Solution {
    //1. 确定dp数组（dp table）以及下标的含义：dp[j]代表达到总和j组合的个数
    //2. 确定递推公式： dp[j] += dp[j - coins[i]];
    //3. dp数组如何初始化
    //4. 确定遍历顺序（从前向后或两个for循环的顺序）
    //5. 举例推导dp数组（打印dp数组）
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        //初始化
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }


    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        Solution sl = new Solution();
        System.out.println(sl.change(amount, coins));
    }
}
