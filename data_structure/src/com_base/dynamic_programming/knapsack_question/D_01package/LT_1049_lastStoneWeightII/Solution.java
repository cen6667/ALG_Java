package com_base.dynamic_programming.knapsack_question.D_01package.LT_1049_lastStoneWeightII;

public class Solution {
//1. 确定dp数组（dp table）以及下标的含义
//2. 确定递推公式
//3. dp数组如何初始化
//4. 确定遍历顺序（从前向后或两个for循环的顺序）
//5. 举例推导dp数组（打印dp数组）
//本题其实就是尽量让石头分成重量相同的两堆，相撞之后剩下的石头最小
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i=0;i<stones.length;i++){
            sum += stones[i];
        }
        int target = sum >> 1;
        //初始化
        int[] dp = new int[target+1];
        for(int i=0;i<stones.length;i++){
            //采用倒序
            for (int j = target; j >= stones[i]; j--) {
                //两种情况，要么放，要么不放
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum-2*dp[target];
    }


    public static void main(String[] args) {
        int[] nums = {2,7,4,1,8,1};
        Solution sl = new Solution();
        System.out.println(sl.lastStoneWeightII(nums));
    }
}
