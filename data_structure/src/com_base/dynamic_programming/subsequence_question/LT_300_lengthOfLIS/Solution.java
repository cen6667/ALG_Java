package com_base.dynamic_programming.subsequence_question.LT_300_lengthOfLIS;

import java.util.Arrays;
//不需要连续
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int result = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i =1;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > result) result = dp[i]; // 取长的子序列
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        Solution sl = new Solution();
        System.out.println(sl.lengthOfLIS(nums));
    }
}
