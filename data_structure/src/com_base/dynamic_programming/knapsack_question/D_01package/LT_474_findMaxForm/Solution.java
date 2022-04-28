package com_base.dynamic_programming.knapsack_question.D_01package.LT_474_findMaxForm;

public class Solution {
    //1. 确定dp数组（dp table）以及下标的含义
    //2. 确定递推公式
    //3. dp数组如何初始化
    //4. 确定遍历顺序（从前向后或两个for循环的顺序）
    //5. 举例推导dp数组（打印dp数组）

    //三维数组或二维滚动数组
    //01背包但是这个背包有两个维度
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]表示i个0和j个1时的最大子集
        int[][] dp = new int[m + 1][n + 1];
        int zeroNum, oneNum;
        for(String str : strs){
            zeroNum = 0;
            oneNum = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            //倒序遍历
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    //还是两种选择，放和不放
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }

        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] nums = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        Solution sl = new Solution();
        System.out.println(sl.findMaxForm(nums, m, n));
    }
}
