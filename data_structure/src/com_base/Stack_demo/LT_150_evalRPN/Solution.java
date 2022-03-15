package com_base.Stack_demo.LT_150_evalRPN;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList();
        for (String token : tokens) {
            char c = token.charAt(0);
            // 单个字符串长度不等于1或是个位数字
            if (!isOpe(token)) {
                stack.push(stoi(token));
            } else if (c == '+') {
                stack.push(stack.pop() + stack.pop());
            } else if (c == '-') {
                stack.push(- stack.pop() + stack.pop());
            } else if (c == '*') {
                stack.push( stack.pop() * stack.pop());
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push( num2/num1);
            }
        }
        return stack.pop();
    }

    private boolean isOpe(String s) {
        return s.length() == 1 && s.charAt(0) <'0' || s.charAt(0) >'9';
    }
    private int stoi(String s) {
        return Integer.valueOf(s);
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(sl.evalRPN(tokens));
    }
}
