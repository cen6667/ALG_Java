package com_base.greedy_algorithm_demo.LT_112_maxProfit;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1){
            return 0;
        }
        int sum = 0;
        int count = 0;
        for (int i = 1; i < prices.length; i++){
            count = prices[i] - prices[i-1];
            if (count <= 0){
                count = 0; // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
            }
            sum += count; // 取区间累计的最大值（相当于不断确定最大子序终止位置）

        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        Solution sl = new Solution();
        System.out.println(sl.maxProfit(nums));
    }
}
