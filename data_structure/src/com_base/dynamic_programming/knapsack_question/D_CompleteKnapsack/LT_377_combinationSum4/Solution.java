package com_base.dynamic_programming.knapsack_question.D_CompleteKnapsack.LT_377_combinationSum4;

public class Solution {
    //1. 确定dp数组（dp table）以及下标的含义：dp[j]代表达到总和j组合的个数
    //2. 确定递推公式： dp[j] += dp[j - coins[i]];
    //3. dp数组如何初始化
    //4. 确定遍历顺序（从前向后或两个for循环的顺序）
    //5. 举例推导dp数组（打印dp数组）
    public int combinationSum4(int[] nums, int target) {
        //主要考查遍历顺序
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];

    }


    public static void main(String[] args) {
        int amount = 4;
        int[] coins = {1, 2, 3};
        Solution sl = new Solution();
        System.out.println(sl.combinationSum4(coins, amount));
    }
}
