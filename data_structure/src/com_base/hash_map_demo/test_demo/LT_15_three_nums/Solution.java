package com_base.hash_map_demo.test_demo.LT_15_three_nums;

import java.util.*;

// 不允许重复，我不知道怎么搞——1.试试先排个序，再去重，让i的值步重复2.试试直接去重

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

//        2.
        Set<List<Integer>> resSet = new HashSet<>();
//        Map<Integer, Integer> map_i = new HashMap<>();
        for (int i=0; i<nums.length; i++){
//            if(map_i.containsKey(nums[i])){
//                break;
//            }
//            map_i.put(nums[i], i);

            int target = -nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i+1; j<nums.length; j++){
                int temp = target - nums[j];
                if(map.containsKey(temp)){
                    List<Integer> reslist = Arrays.asList(nums[i], nums[map.get(temp)], nums[j]);
                    if(resSet.add(reslist)){
                        result.add(reslist);
                    }
//                    result.add(Arrays.asList(nums[i], nums[map.get(temp)], nums[j]));
                }
                map.put(nums[j], j);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {0,0,0,0};
        List<List<Integer>> result = Solution.threeSum(nums);
        for(List<Integer> reslist: result ){
            System.out.println('[');
            for(int i: reslist){
                System.out.println(i);
            }
            System.out.println(']');
        }
    }
}
