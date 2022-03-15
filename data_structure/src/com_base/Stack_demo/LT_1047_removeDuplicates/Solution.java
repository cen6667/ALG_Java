package com_base.Stack_demo.LT_1047_removeDuplicates;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            char c =s.charAt(i);
            if(stack.isEmpty() || c != stack.peek()){
                stack.push(c);
            }else {
                stack.pop();
            }
        }
        StringBuilder resb = new StringBuilder();
        while(!stack.isEmpty()){
            resb.append(stack.pop());
        }

        return resb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution sl = new Solution();

        String s = "adfsasdfsssac";
        System.out.println(sl.removeDuplicates(s));
    }
}
