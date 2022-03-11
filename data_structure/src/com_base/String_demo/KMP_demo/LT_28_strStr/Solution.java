package com_base.String_demo.KMP_demo.LT_28_strStr;

public class Solution {
    public int strStr(String haystack, String needle) {
        //注意空值
        if(needle.length()==0){
            return 0;
        }

        int[] next = new int[needle.length()];
        //获取next数组
        getNext(next, needle);

        for (int i = 0, j = 0; i < haystack.length(); i++) {
            //不匹配的情况
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j-1];
            }
            //匹配的情况
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            //输出
            if (j == needle.length()) {
                return (i - needle.length() + 1);
            }
        }
        return -1;
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
//        String haystack = "mississippi";
//        String needle = "issip"; // next=[0,0,0,1,0]
        String haystack = "misisisisppi";
        String needle = "isisp"; // next=[0,0,1,2,0]
        int res = sl.strStr(haystack, needle);
        System.out.println(res);
    }
}
