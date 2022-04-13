package com_base.greedy_algorithm_demo.LT_45_jump;

public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        //记录跳跃的次数
        int count=0;
        //当前的覆盖最大区域
        int curDistance = 0;
        //最大的覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大的覆盖区域
            maxDistance = Math.max(maxDistance,i+nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if (maxDistance>=nums.length-1){
                count++;
                break;
            }
            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            //i==curDistance最重要的一句话，达到一个范围的底部必须加一
            // 但最大的范围是整个范围的，不是底部的，不用担心不是最优
            if (i==curDistance){
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,0,1,3,1,4};
        Solution sl = new Solution();
        System.out.println(sl.jump(nums));
    }
}
