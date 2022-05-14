package com_base.Monotonic_stack.LT_739_dailyTemperatures;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    // 单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];

        Deque<Integer> deque = new LinkedList<>();
        deque.push(0);

        for (int i = 1; i < len; i++) {
            while (!deque.isEmpty() && temperatures[deque.peek()] < temperatures[i]) {
                res[deque.peek()] = i - deque.peek();
                deque.pop();
            }
            deque.push(i);
        }
        return res;
    }
    /**
     * 最简单莫过于双重循环，笔试时至少不会丢分
     */
    public int[] dailyTemperatures2(int[] T) {
        int[] res = new int[T.length];
        for (int i = 0; i < T.length - 1; i++) {
            for (int j =  i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        Solution sl = new Solution();
        System.out.println(Arrays.toString(sl.dailyTemperatures(nums)));
    }
}
