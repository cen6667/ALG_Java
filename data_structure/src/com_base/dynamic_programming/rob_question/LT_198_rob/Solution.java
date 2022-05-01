package com_base.dynamic_programming.rob_question.LT_198_rob;

public class Solution {
    public int rob(int[] nums) {
        if(nums.length ==1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i=2; i<nums.length;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        Solution sl = new Solution();
        System.out.println(sl.rob(nums));
    }

}
