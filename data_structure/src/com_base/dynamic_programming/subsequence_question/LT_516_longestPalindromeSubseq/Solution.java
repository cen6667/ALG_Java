package com_base.dynamic_programming.subsequence_question.LT_516_longestPalindromeSubseq;

//不需要连续，只需要顺序
public class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) { // 从后往前遍历 保证情况不漏
            dp[i][i] = 1; // 初始化
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
                }
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        String text1 = "bbbab";
        Solution sl = new Solution();
        System.out.println(sl.longestPalindromeSubseq(text1));
    }
}
