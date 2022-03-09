package com_base.hash_map_demo.test_demo.LT_18_four_nums;

import java.util.*;

// 不允许重复，我不知道怎么搞——1.试试先排个序，再去重，让i的值步重复2.试试直接去重

public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int k = 0; k < nums.length; k++) {
            int temp = target - nums[k];
            // 这种剪枝是错误的，这道题目target 是任意值
            // if (nums[k] > target) {
            //     return result;
            // }
            // 去重
            if (k > 0 && nums[k] == nums[k - 1]) continue;

            for (int i = k + 1; i < nums.length; i++) {
                //正确去重，这里要注意i-1不能等于k
                if (i > k + 1 && nums[i] == nums[i - 1]) continue;
                int left = i + 1;
                int right = nums.length - 1;

                while (right > left) {
                    int sum = nums[k] + nums[i] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[k], nums[i], nums[left], nums[right]));

                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        right--;
                        left++;
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
        int target = -11;
//        int[] nums = {0,0,0,0};
        List<List<Integer>> result = Solution.fourSum(nums, target);
        for (List<Integer> reslist : result) {
            System.out.println('[');
            for (int i : reslist) {
                System.out.println(i);
            }
            System.out.println(']');
        }
    }
}
