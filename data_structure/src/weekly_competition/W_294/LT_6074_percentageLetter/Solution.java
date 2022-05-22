package weekly_competition.W_294.LT_6074_percentageLetter;

public class Solution {
    public static int percentageLetter(String s, char letter) {

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) count++;
        }
        return count*100/s.length();
    }

    public static void main(String[] args) {
        String s = "foobar";
        char letter = 'z';
        System.out.println(Solution.percentageLetter(s,letter));
    }
}
