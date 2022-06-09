package demo.demo;

import java.util.Arrays;

public class Solution {

    public static int solve(int n) {
        if (n<=3) return n;
        int[][] dp = new int[n+1][2];
        dp[1][0] = 1;
        dp[2][1] = 1;
        dp[2][0] = 1;

        for (int i=3; i<=n; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][0];
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n-1][0] + dp[n-2][1];
    }

    public static void main(String[] args) {
        System.out.println(solve(4));
    }

}
