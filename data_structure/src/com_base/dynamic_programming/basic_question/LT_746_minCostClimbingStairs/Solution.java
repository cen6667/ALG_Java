package com_base.dynamic_programming.basic_question.LT_746_minCostClimbingStairs;

public class Solution {
    //1.确定dp数组以及下标的含义：到达第i个台阶所花费的最少体力为dp[i]
    //2.确定递推公式：dp[i] = min(dp[i - 1], dp[i - 2]) + cost[i];
    //3.dp数组如何初始化
    //4.确定遍历顺序
    //5.举例推导dp数组
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2; i<cost.length; i++){
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        //最后一步，如果是由倒数第二步爬，则最后一步的体力花费可以不用算
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public static void main(String[] args) {
        int[] nums = {10,15,19};
        Solution sl = new Solution();
        System.out.println(sl.minCostClimbingStairs(nums));
    }
}
