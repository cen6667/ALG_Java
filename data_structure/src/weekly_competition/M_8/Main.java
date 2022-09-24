package weekly_competition.M_8;

import java.util.Arrays;
import java.util.Scanner;

/*
3
13
123
24

*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            sc.nextLine();
            System.out.println(helper(num));
        }
    }

    public static int helper(int num){
        if(num%2 == 0) return num;
        StringBuilder sb = new StringBuilder(num+"");
        boolean flag = true;
        int index = 0;
        for (int i = 0; i < sb.length(); i++) {
            int c = sb.charAt(i);
            if(c%2 == 0) {
                flag = false;
                index = i;
                break;
            }
        }
        if(flag) return -1;
        int index2 = sb.length() - index - 1;
        int b = (int) Math.pow(10, index2);
        num = num - b*(sb.charAt(index)-'0');
        num = num - (sb.charAt(sb.length()-1)-'0');
        num += b*(sb.charAt(sb.length()-1)-'0');
        num += sb.charAt(index)-'0';
        return num;
    }

}
