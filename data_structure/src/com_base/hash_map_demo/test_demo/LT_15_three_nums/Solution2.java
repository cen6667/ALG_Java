package com_base.hash_map_demo.test_demo.LT_15_three_nums;

import java.util.*;

// 不允许重复，我不知道怎么搞——1.试试先排个序，再去重，让i的值步重复2.试试直接去重

public class Solution2 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {0,0,0,0};
        List<List<Integer>> result = Solution2.threeSum(nums);
        for(List<Integer> reslist: result ){
            System.out.println('[');
            for(int i: reslist){
                System.out.println(i);
            }
            System.out.println(']');
        }
    }
}
