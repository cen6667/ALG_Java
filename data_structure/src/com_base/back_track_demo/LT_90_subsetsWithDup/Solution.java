package com_base.back_track_demo.LT_90_subsetsWithDup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    // 想要达到限制for循环，不限制递归就必须用到它，限制横向，不限制纵向，意思是只在回溯后检测是否是相同元素
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //先排序
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backTracking(nums, 0);
        return result;
    }

    private void backTracking(int[] nums, int startIndex){
        //终止条件
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length){
            return;
        }

        for (int i = startIndex; i < nums.length; i++){
            //!used[i-1]意思是只在回溯后检测是否是相同元素
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTracking(nums, i + 1);
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3};

        Solution sl = new Solution();

        System.out.println(sl.subsetsWithDup(nums));
    }
}
