package weekly_competition.W_289.LT_6070_digitSum;


public class Solution {
    public String digitSum(String s, int k) {
        if (s.length() <= k) return s;
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i <= (s.length() - 1)/ k; i++) {
            int sum = 0;
            int min_index = Math.min(i * k + k,s.length());
            for (int j = i * k; j < min_index; j++) {
                sum += s.charAt(j) - '0';
            }
            tmp.append(sum);
        }
        return digitSum(tmp.toString(),k);
    }

    public static void main(String[] args) {
//        String nums = "11111222223";
        String nums = "1111223411";
//        String nums = "00000000";
        int k = 3;
        Solution sl = new Solution();
        System.out.println(sl.digitSum(nums, k));
    }
}
