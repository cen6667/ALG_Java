package weekly_competition.W_292.LT_6058_countTexts;

public class Solution2 {
    private static final int mod = 1000000007;

    public int countTexts(String pressedKeys) {
        char[] keys = pressedKeys.toCharArray();
        int n = keys.length;

        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i-1];
            int offset = (keys[i] == '7' || keys[i] == '9') ? 4 : 3;
            for (int j = 1; j < offset; j++) {
                if (i < j || keys[i] != keys[i-j]) break;
                ans[i] += (i == j) ? 1 : ans[i-j-1];
                ans[i] %= mod;
            }
        }

        return ans[n-1];
    }

    public static void main(String[] args) {
        String pressedKeys = "22233";
//        String pressedKeys = "222222222222222222222222222222222222";
        Solution2 sl = new Solution2();
        System.out.println(sl.countTexts(pressedKeys));
    }

}
