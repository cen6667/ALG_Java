package com_base.Stack_demo.LT_1047_removeDuplicates;

import java.util.ArrayDeque;

public class Solution2 {
    public String removeDuplicates(String s) {
        //ArrayDeque会比LinkedList在除了删除元素这一点外会快一点
        //参考：https://stackoverflow.com/questions/6163166/why-is-arraydeque-better-than-linkedlist
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            char c =s.charAt(i);
            if(stack.isEmpty() || c != stack.peek()){
                stack.push(c);
            }else {
                stack.pop();
            }
        }
        String str = "";
        //剩余的元素即为不重复的元素
        while (!stack.isEmpty()) {
            str = stack.pop() + str;
        }
        return str;
    }

    public static void main(String[] args) {
        Solution2 sl = new Solution2();

        String s = "adfsasdfsssac";
        System.out.println(sl.removeDuplicates(s));
    }
}
