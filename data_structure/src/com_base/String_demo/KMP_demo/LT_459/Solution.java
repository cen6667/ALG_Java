package com_base.String_demo.KMP_demo.LT_459;

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int m = s.length();
        if (m == 0) return false;

        int[] next = new int[s.length()];
        //获取next数组
        getNext(next, s);
        //找到周期
        int num = m - next[m-1];

        if(next[m-1]!=0 && m%num==0){
            return true;
        }else return false;
    }

    private void getNext(int[] next, String needle) {
        char[] s = needle.toCharArray();
        next[0] = 0;
        //i是后缀最后一个元素，j是前缀最后一个元素
        for (int i = 1, j = 0; i < s.length; i++) {
            //处理前后缀不相同情况
            while (j > 0 && s[i] != s[j]) {
                j = next[j - 1];
            }
            //处理前后缀相同情况
            if (s[i] == s[j]) j++;
            next[i] = j;
        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
//        String s = "abcabcabc";
//        String s = "abababab";
        String s = "abaabaaba";
//        String s = "ababa";

        boolean res = sl.repeatedSubstringPattern(s);
        System.out.println(res);
    }
}
