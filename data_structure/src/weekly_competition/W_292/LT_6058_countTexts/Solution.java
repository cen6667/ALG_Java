package weekly_competition.W_292.LT_6058_countTexts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    public int countTexts(String pressedKeys) {
        int resultCount = 1;
        pressedKeys += "0";
        int j = 0;
        for (int i = 1; i < pressedKeys.length(); i++) {
            if(pressedKeys.charAt(i)!=pressedKeys.charAt(j)){
                resultCount *= numApart(pressedKeys.charAt(j)-'0',i-j);
                j = i;
            }
        }
        return resultCount % 1000000007;
    }

    private int numApart(int num, int length){
        int tmpCount = 0;
        if(num==7||num==9){
            tmpCount = climbStairs(length, 4);
        }else{
            tmpCount = climbStairs(length, 3);
        }
        return tmpCount;
    }

    public int climbStairs(int n, int m) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) { // 把m换成2，就可以AC爬楼梯这道题
                if (i - j >= 0) dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }



    public static void main(String[] args) {
//        String pressedKeys = "22233";
        String pressedKeys = "222222222222222222222222222222222222";
        Solution sl = new Solution();
        System.out.println(sl.countTexts(pressedKeys));
    }

}
