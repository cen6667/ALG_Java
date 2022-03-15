package com_base.Stack_demo.LT_1047_removeDuplicates;

import java.util.Deque;
import java.util.LinkedList;

public class Solution3 {
    public String removeDuplicates(String s) {
        // 将 res 当做栈
        StringBuilder res = new StringBuilder();
        // top为 res 的长度
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 当 top > 0,即栈中有字符时，当前字符如果和栈中字符相等，弹出栈顶字符，同时 top--
            if (top >= 0 && res.charAt(top) == c) {
                res.deleteCharAt(top);
                top--;
                // 否则，将该字符 入栈，同时top++
            } else {
                res.append(c);
                top++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution3 sl = new Solution3();

        String s = "adfsasdfsssac";
        System.out.println(sl.removeDuplicates(s));
    }
}
