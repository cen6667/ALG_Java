package weekly_competition.W_292.LT_6056_largestGoodInteger;

public class Solution {
    public String largestGoodInteger(String num) {
        int max = -1;
        int j = 0;
        char[] chars = num.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[j]) {
                j = i;
            } else if (i - j == 2) {
                max = Math.max(max, chars[i] - '0');
            }
        }
        if (max == -1) return "";
        return "" + max + max + max;
    }

    public static void main(String[] args) {

        String num = "42352338";
//        String num = "6777133339";
        Solution sl = new Solution();
        System.out.println(sl.largestGoodInteger(num));
    }
}
