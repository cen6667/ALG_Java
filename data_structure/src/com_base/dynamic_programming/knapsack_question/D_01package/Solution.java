package com_base.dynamic_programming.knapsack_question.D_01package;

public class Solution {
//1. 确定dp数组（dp table）以及下标的含义
//2. 确定递推公式
//3. dp数组如何初始化
//4. 确定遍历顺序（从前向后或两个for循环的顺序）
//5. 举例推导dp数组（打印dp数组）
    public int package_01(int capacity, int[] weight, int[] value) {
        //二维数组
        int[][] dp = new int[weight.length][capacity+1];
        //初始化，第一行
        for (int i = weight[0]; i < capacity; i++) {
            dp[0][i] = value[0];
        }
        //递推，i是[0,i]的
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                //如果包容量不够，直接不能装
                if (j < weight[i]) dp[i][j] = dp[i - 1][j];
                //dp[i - 1][j - weight[i]] + value[i]：看是否可以添加其他物品[j - weight[i]]，最后加上自己的value
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
            }
        }
        return dp[weight.length-1][capacity];
    }


    public static void main(String[] args) {
        int capacity = 4;
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        Solution sl = new Solution();
        System.out.println(sl.package_01(capacity, weight, value));
    }
}
