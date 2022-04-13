package com_base.greedy_algorithm_demo.LT_1005_largestSumAfterKNegations;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        // 如果k还大于0，那么反复转变数值最小的元素，将K用完

        if (k % 2 == 1) nums[len - 1] = -nums[len - 1];
        return Arrays.stream(nums).sum();

    }

    public int largestSumAfterKNegations2(int[] A, int k) {
        //巧妙，三种情况
        // 1.全正数
        // 2.负数数量大于k：前一个负数的abs一定大于下一个负数，idx++
        // 3.负数数量小于k：最后一个负数的abs不一定大于下一个正数，判断后，idx++
        if (A.length == 1) return k % 2 == 0 ? A[0] : -A[0];
        Arrays.sort(A);
        int sum = 0;
        int idx = 0;
        for (int i = 0; i < k; i++) {
            if (i < A.length - 1 && A[idx] < 0) {
                A[idx] = -A[idx];
                if (A[idx] >= Math.abs(A[idx + 1])) idx++;
                continue;
            }
            A[idx] = -A[idx];
        }

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 5, -4};
        int k = 2;
        Solution sl = new Solution();
        System.out.println(sl.largestSumAfterKNegations2(nums, k));
    }
}
