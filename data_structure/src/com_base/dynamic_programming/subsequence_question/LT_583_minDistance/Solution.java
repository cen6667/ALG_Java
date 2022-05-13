package com_base.dynamic_programming.subsequence_question.LT_583_minDistance;

//不需要连续，只需要顺序
public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) dp[i][0] = i;
        for (int j = 0; j < word2.length() + 1; j++) dp[0][j] = j;

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                //相等所以不需要删除
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //三种情况
                    //情况一：删word1[i - 1]，最少操作次数为dp[i - 1][j] + 1
                    //情况二：删word2[j - 1]，最少操作次数为dp[i][j - 1] + 1
                    //情况三：同时删word1[i - 1]和word2[j - 1]，操作的最少次数为dp[i - 1][j - 1] + 2
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2,
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    //本题和动态规划：1143.最长公共子序列基本相同，只要求出两个字符串的最长公共子序列长度即可，
    //那么除了最长公共子序列之外的字符都是必须删除的，最后用两个字符串的总长度减去两个最长公共子序列的长度就是删除的最少步数。
    public int minDistance2(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1]; // 先对dp数组做初始化操作
        for (int i = 1; i <= word1.length(); i++) {
            char char1 = word1.charAt(i - 1);
            for (int j = 1; j <= word2.length(); j++) {
                char char2 = word2.charAt(j - 1);
                if (char1 == char2) { // 开始列出状态转移方程
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String text1 = "sea";
        String text2 = "eat";
        Solution sl = new Solution();
        System.out.println(sl.minDistance2(text1, text2));
    }
}
