package com_base.back_track_demo.LT_491_findSubsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
//    不能排序，所以对于重复元素做不到去重所以需要添加hash去重

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return result;
    }

    private void backTracking(int[] nums, int startIndex){
        //终止条件
        if(path.size()>1) result.add(new ArrayList<>(path));
        //不能排序，所以需要添加hash给每层去重-100 <= nums[i] <= 100
        int[] used = new int[201];
        for (int i = startIndex; i < nums.length; i++){
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) ||
                    (used[nums[i] + 100] == 1)) continue;
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {4,4,3,2,1};
        int[] nums2 = {4,7,6,7};
        Solution sl = new Solution();

        System.out.println(sl.findSubsequences(nums));
        System.out.println(sl.findSubsequences(nums2));
    }
}
