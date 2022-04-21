package com_base.dynamic_programming.basic_question.LT_509_fib;

public class Solution {
    //数组版
    public int fib2(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int index = 2; index <= n; index++) {
            dp[index] = dp[index - 1] + dp[index - 2];
        }
        return dp[n];
    }

    //普通版
    public int fib(int n) {
        if (n < 2) return n;
        int res = 0;
        //1.确定dp数组以及下标的含义
        //2.确定递推公式
        //3.dp数组如何初始化
        int f0 = 0;
        int f1 = 1;
        //4.确定遍历顺序
        //5.举例推导dp数组
        for (int i = 2; i <= n; i++) {
            res = f1 + f0;
            f0 = f1;
            f1 = res;
        }
        return res;
    }

    //递归 时间复杂度：O(2n) 空间复杂度：O(n)
    public int fib3(int n) {
        if (n < 2) return n;
        return fib3(n - 1) + fib3(n - 2);
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.fib(10));
    }
}
