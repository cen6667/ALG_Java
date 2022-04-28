package com_base.dynamic_programming.knapsack_question.D_CompleteKnapsack;

public class Solution {
/*01背包内嵌的循环是从大到小遍历，为了保证每个物品仅被添加一次。
而完全背包的物品是可以添加多次的，所以要从小到大去遍历*/
    public int completeKnapsack(int capacity, int[] weight, int[] value) {
        // 先遍历物品，在遍历背包
        int[] dp = new int[capacity + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < weight.length; i++){
            for (int j = weight[i]; j <= capacity; j++){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[capacity];
    }

    public int completeKnapsack2(int capacity, int[] weight, int[] value) {
        // 先遍历背包，再遍历物品
        int[] dp = new int[capacity + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i <= capacity; i++){
            for (int j = 0; j < weight.length; j++){
                if (i - weight[j] >= 0){
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
                }
            }
        }
        return dp[capacity];
    }


    public static void main(String[] args) {
        int capacity = 4;
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        Solution sl = new Solution();
        System.out.println(sl.completeKnapsack2(capacity, weight, value));
    }
}
