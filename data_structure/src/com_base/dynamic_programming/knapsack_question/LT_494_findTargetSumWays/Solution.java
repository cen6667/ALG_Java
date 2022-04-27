package com_base.dynamic_programming.knapsack_question.LT_494_findTargetSumWays;

public class Solution {
    //1. 确定dp数组（dp table）以及下标的含义
    //2. 确定递推公式
    //3. dp数组如何初始化
    //4. 确定遍历顺序（从前向后或两个for循环的顺序）
    //5. 举例推导dp数组（打印dp数组）
    //背包容量：(S+sum)/2
    //dp[j] 表示：填满j（包括j）这么大容积的包，有dp[j]种方法
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((target + sum) % 2 != 0) return 0;

        int size = (sum+target)>>1;
        if(Math.abs(target) > sum) return 0;
        if(size < 0) size = -size;
        int[] dp = new int[size+1];
        //初始化
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                //上面可能性，再加自己的可能数量
                dp[j]+= dp[j - nums[i]];
            }
        }
        return dp[size];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int k = 3;
        Solution sl = new Solution();
        System.out.println(sl.findTargetSumWays(nums, k));
    }
}
