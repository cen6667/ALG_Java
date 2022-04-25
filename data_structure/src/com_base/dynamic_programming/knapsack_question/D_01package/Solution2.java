package com_base.dynamic_programming.knapsack_question.D_01package;

public class Solution2 {
//1. 确定dp数组（dp table）以及下标的含义
//2. 确定递推公式
//3. dp数组如何初始化
//4. 确定遍历顺序（从前向后或两个for循环的顺序）
//5. 举例推导dp数组（打印dp数组）
    public int package_01(int capacity, int[] weight, int[] value) {
        //滚动数组:满足的条件是上一层可以重复利用，直接拷贝到当前层
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[capacity + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < weight.length; i++){
            for (int j = capacity; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[capacity];
    }


    public static void main(String[] args) {
        int capacity = 4;
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        Solution2 sl = new Solution2();
        System.out.println(sl.package_01(capacity, weight, value));
    }
}
