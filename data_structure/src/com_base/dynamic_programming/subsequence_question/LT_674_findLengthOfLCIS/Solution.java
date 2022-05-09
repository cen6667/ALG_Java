package com_base.dynamic_programming.subsequence_question.LT_674_findLengthOfLCIS;

import java.util.Arrays;
//需要连续
public class Solution {
    /**
     * 1.dp[i] 代表当前下标最大连续值
     * 2.递推公式 if（nums[i+1]>nums[i]） dp[i+1] = dp[i]+1
     * 3.初始化 都为1
     * 4.遍历方向，从其那往后
     * 5.结果推导 。。。。
     */
    public static int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            res = res > dp[i + 1] ? res : dp[i + 1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        Solution sl = new Solution();
        System.out.println(sl.findLengthOfLCIS(nums));
    }
}
