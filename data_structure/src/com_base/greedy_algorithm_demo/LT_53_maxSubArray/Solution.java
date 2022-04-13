package com_base.greedy_algorithm_demo.LT_53_maxSubArray;

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int i:nums){
            count += i;
            sum = Math.max(sum,count);
            if(count<0){
                count=0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Solution sl = new Solution();
        System.out.println(sl.maxSubArray(nums));
    }
}
