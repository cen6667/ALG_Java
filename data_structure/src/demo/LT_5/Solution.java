package demo.LT_5;

import java.util.Arrays;

public class Solution {
    public static String longestPalindrome(String s) {
        //动态规划
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];
        //初始化，单个字符为回文
        for(int i = 0; i<len;i++){
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 列
        for(int j=1; j<len;j++){
            // 行
            for(int i = 0;i<j;i++){
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
                // 如果为true，i变大会减小长度，没必要再计算
//                if(dp[i][j]) break;
            }

        }
        for(boolean[] arr :dp){
            System.out.println(Arrays.toString(arr));
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(longestPalindrome(s));
    }
}