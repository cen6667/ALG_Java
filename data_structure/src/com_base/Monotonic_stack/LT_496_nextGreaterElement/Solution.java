package com_base.Monotonic_stack.LT_496_nextGreaterElement;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    //
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);

        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0 ; i< nums1.length ; i++){
            hashMap.put(nums1[i],i);
        }
        // 求出nums2中所有非单调的元素，再去nums1中找是否存在。存在就输出
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= nums2[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                    if (hashMap.containsKey(nums2[stack.peek()])){
                        Integer index = hashMap.get(nums2[stack.peek()]);
                        res[index] = nums2[i];
                    }
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }



    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        Solution sl = new Solution();
        System.out.println(Arrays.toString(sl.nextGreaterElement(nums1,nums2)));
    }
}
