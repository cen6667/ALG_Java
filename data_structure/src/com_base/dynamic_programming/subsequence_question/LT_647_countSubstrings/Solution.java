package com_base.dynamic_programming.subsequence_question.LT_647_countSubstrings;

//不需要连续，只需要顺序
public class Solution {
    public int countSubstrings(String s) {
        int len, result = 0;
        if (s == null || (len = s.length()) < 1) return 0;
        //dp[i][j]：s字符串下标i到下标j的字串是否是一个回文串，即s[i, j]
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                //当两端字母一样时，才可以两端收缩进一步判断
                if (s.charAt(i) == s.charAt(j)) {
                    //i++，j--，即两端收缩之后i,j指针指向同一个字符或者i超过j了,必然是一个回文串
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        result++;
                    } else if (dp[i + 1][j - 1]){
                        //否则通过收缩之后的字串判断
                        result++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return result;
    }
    // 双指针
    public int countSubstrings2(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            //通过遍历每个回文中心，向两边扩散，并判断是否回文字串
            //有两种情况，left == right，right = left + 1，这两种回文中心是不一样的
            result += extend(s, i, i, s.length()); // 以i为中心
            result += extend(s, i, i + 1, s.length()); // 以i和i+1为中心
        }
        return result;
    }

    public int extend(String s, int i, int j, int n) {
        int res = 0;
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        String text1 = "fdsklf";
        Solution sl = new Solution();
        System.out.println(sl.countSubstrings2(text1));
    }
}
