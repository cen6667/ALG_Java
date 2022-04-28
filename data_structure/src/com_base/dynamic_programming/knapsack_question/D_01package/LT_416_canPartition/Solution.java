package com_base.dynamic_programming.knapsack_question.D_01package.LT_416_canPartition;

public class Solution {
    //1. 确定dp数组（dp table）以及下标的含义
    //2. 确定递推公式
    //3. dp数组如何初始化
    //4. 确定遍历顺序（从前向后或两个for循环的顺序）
    //5. 举例推导dp数组（打印dp数组）
    //背包容量：sum/2
    //dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        //总和为奇数，不能平分
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for(int i = 0; i < n; i++){
            for(int j = target; j >= nums[i]; j--){
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        Solution sl = new Solution();
        System.out.println(sl.canPartition(nums));
    }
}
