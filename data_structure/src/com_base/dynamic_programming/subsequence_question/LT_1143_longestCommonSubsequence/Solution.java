package com_base.dynamic_programming.subsequence_question.LT_1143_longestCommonSubsequence;

//不需要连续，只需要顺序
public class Solution {
    //二维数组，因为要用左上方的值，可能不容易滚动数组
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1]; // 先对dp数组做初始化操作
        for (int i = 1 ; i <= text1.length() ; i++) {
            char char1 = text1.charAt(i - 1);
            for (int j = 1; j <= text2.length(); j++) {
                char char2 = text2.charAt(j - 1);
                if (char1 == char2) { // 开始列出状态转移方程
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }


    public static void main(String[] args) {
//        String text1 = "abcbe";
//        String text2 = "ace";
//        String text1 = "abcba";
//        String text2 = "abcbcba";
        String text1 = "bsbininm";
        String text2 = "jmjkbkjkv";
        Solution sl = new Solution();
        System.out.println(sl.longestCommonSubsequence(text1,text2));
    }
}
