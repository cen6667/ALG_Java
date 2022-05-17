package com_base.Monotonic_stack.LT_503_nextGreaterElements;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    // 单调栈
    public int[] nextGreaterElements(int[] nums){
        //边界判断
        if(nums == null || nums.length <= 1) {
            return new int[]{-1};
        }
        int size = nums.length;
        int[] result = new int[size];//存放结果
        Arrays.fill(result,-1);//默认全部初始化为-1
        Deque<Integer> st= new LinkedList<>();//栈中存放的是nums中的元素下标
        for(int i = 0; i < 2*size; i++) {
            while(!st.isEmpty() && nums[i % size] > nums[st.peek()]) {
                result[st.peek()] = nums[i % size];//更新result
                st.pop();//弹出栈顶
            }
            st.push(i % size);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        Solution sl = new Solution();
        System.out.println(Arrays.toString(sl.nextGreaterElements(nums)));
    }
}
