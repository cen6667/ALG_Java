package weekly_competition.W_291.LT_6047_removeDigit;

public class Solution {
    public String removeDigit(String number, char digit) {
        int size = number.length();
        int index = -1;
        for (int i = size - 1; i >= 0; i--) {
            if (digit == number.charAt(i)) {
                if (index < 0) {
                    index = i;
                } else if (digit - number.charAt(i + 1) < 0) {
                    index = i;
                }
            }
        }
        return number.substring(0, index)+number.substring(index+1);
    }

    public static void main(String[] args) {
        String s = "1231";
        char num = '1';
//        String s = "677642";
//        char num = '6';

        Solution sl = new Solution();
        System.out.println(sl.removeDigit(s, num));
    }
}
