package com_base.dynamic_programming.knapsack_question.D_CompleteKnapsack.LT_279_numSquares;

public class Solution {
    //1. 确定dp数组（dp table）以及下标的含义
    //2. 确定递推公式
    //3. dp数组如何初始化
    //4. 确定遍历顺序（从前向后或两个for循环的顺序）
    //5. 举例推导dp数组（打印dp数组）
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        //初始化
        for (int j = 0; j <= n; j++) {
            dp[j] = max;
        }
        //当和为0时，组合的个数为0
        dp[0] = 0;
        // 遍历物品
        for (int i = 1; i * i <= n; i++) {
            // 遍历背包，神了，完全平方数还能这样写，不是固定数量
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != max) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int n = 12;
        Solution sl = new Solution();
        System.out.println(sl.numSquares(n));
    }
}
