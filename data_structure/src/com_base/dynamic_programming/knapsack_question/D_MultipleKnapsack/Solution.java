package com_base.dynamic_programming.knapsack_question.D_MultipleKnapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int testMultiPack1(int[] weight, int[] value,int[] nums, int bagWeight){
        // 版本一：改变物品数量为01背包格式
        List<Integer> weightList = Arrays.stream(weight).boxed().collect(Collectors.toList());;
        List<Integer> valueList = Arrays.stream(value).boxed().collect(Collectors.toList());
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < numsList.size(); i++) {
            while (numsList.get(i) > 1) { // 把物品展开为i
                weightList.add(weightList.get(i));
                valueList.add(valueList.get(i));
                numsList.set(i, numsList.get(i) - 1);
            }
        }

        int[] dp = new int[bagWeight + 1];
        for(int i = 0; i < weightList.size(); i++) { // 遍历物品
            for(int j = bagWeight; j >= weightList.get(i); j--) { // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weightList.get(i)] + valueList.get(i));
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[bagWeight];
    }

    public int testMultiPack2(int[] weight, int[] value,int[] nums,int bagWeight){
        // 版本二：改变遍历个数
        int[] dp = new int[bagWeight + 1];
        for(int i = 0; i < weight.length; i++) { // 遍历物品
            for(int j = bagWeight; j >= weight[i]; j--) { // 遍历背包容量
                // 以上为01背包，然后加一个遍历个数
                for (int k = 1; k <= nums[i] && (j - k * weight[i]) >= 0; k++) { // 遍历个数
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
                System.out.println(Arrays.toString(dp));
            }
        }
        return dp[bagWeight];
    }

    public static void main(String[] args) {
        int[] weight = new int[] {1, 3, 4};
        int[] value = new int[] {15, 20, 30};
        int[] nums = new int[] {2, 3, 2};
        int bagWeight = 10;
        Solution sl = new Solution();
        System.out.println(sl.testMultiPack1(weight,value,nums,bagWeight));
    }
}
