package com_base.Stack_demo.LT_71_simplifyPath;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] paths = path.split("/+");

        for(String s:paths){
            if(s.equals("..") && !stack.isEmpty()) stack.pop();
            else if(s.equals("") || s.equals(".")) ;
            else if(!s.equals("..")){
                stack.push(s);
            }
        }
        StringBuilder res = new StringBuilder();
        if (stack.isEmpty()) return "/";
        while (!stack.isEmpty()){
            res.append("/");
            res.append(stack.pollLast());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        String[] paths = {"/a/./b/../../c/", "/../", "/home//foo/", "/a/../../b/../c//.//"};

//        String path = "/../";
//        String path = "/home//foo/";
//        String path = "/a/../../b/../c//.//";
        for(String s: paths) System.out.println(sl.simplifyPath(s));

    }
}
