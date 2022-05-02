package com_base.dynamic_programming.rob_question.LT_213_rob2;
//成环
//情况二：考虑包含首元素，不包含尾元素
//情况三：考虑包含尾元素，不包含首元素
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        if (len == 1)
            return nums[0];
        return Math.max(robAction(nums, 0, len - 1), robAction(nums, 1, len));
    }

    int robAction(int[] nums, int start, int end) {
        int x = 0, y = 0, z = 0;
        for (int i = start; i < end; i++) {
            y = z;
            z = Math.max(y, x + nums[i]);
            x = y;
        }
        return z;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        Solution sl = new Solution();
        System.out.println(sl.rob(nums));
    }

}
