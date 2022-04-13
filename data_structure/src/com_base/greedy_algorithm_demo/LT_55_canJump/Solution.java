package com_base.greedy_algorithm_demo.LT_55_canJump;

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        Solution sl = new Solution();
        System.out.println(sl.canJump(nums));
    }
}
