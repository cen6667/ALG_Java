package weekly_competition.M_1;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int res = helper(str);
        System.out.println(res);
    }

    static char[] failed = {'f','a','i','l','e','d'};

    public static int helper(String str){
        int res = 0;
        int len = str.length();
        StringBuilder sb = new StringBuilder(str);

        while (sb.length() != 0){
            // 循环
            int n = 0;
            int i = 0;
            while (i != sb.length()) {
                if(sb.charAt(i) == failed[n]){
                    sb.deleteCharAt(i);
                    n++;
                    n = n%6;
                }else{
                    i++;
                }

            }
            res++;
        }
        return res;
    }
}
