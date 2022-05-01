package com_base.dynamic_programming.knapsack_question.D_CompleteKnapsack.LT_139_wordBreak;

import java.util.Arrays;
import java.util.List;

public class Solution {
    //1. 确定dp数组（dp table）以及下标的含义
    //2. 确定递推公式
    //3. dp数组如何初始化
    //4. 确定遍历顺序（从前向后或两个for循环的顺序）
    //5. 举例推导dp数组（打印dp数组）
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        //初始化
        dp[0] = true;
        //遍历背包
        for (int i = 1; i <= s.length(); i++) {
            //遍历物品
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j,i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        Solution sl = new Solution();
        System.out.println(sl.wordBreak(s, wordDict));
    }
}
