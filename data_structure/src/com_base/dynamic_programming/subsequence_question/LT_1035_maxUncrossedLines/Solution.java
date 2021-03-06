package com_base.dynamic_programming.subsequence_question.LT_1035_maxUncrossedLines;

public class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int [][] dp = new int[A.length+1][B.length+1];
        for(int i=1;i<=A.length;i++) {
            for(int j=1;j<=B.length;j++) {
                if (A[i-1]==B[j-1]) {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[A.length][B.length];
    }


    public static void main(String[] args) {
        int[] nums1 = {1,4,2};
        int[] nums2 = {1,2,4};
        Solution sl = new Solution();
        System.out.println(sl.maxUncrossedLines(nums1,nums2));
    }
}
