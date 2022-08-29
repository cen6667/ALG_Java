package weekly_competition.M_6;

import java.util.Scanner;

/*
5 8 3

*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int sum = a + b;
        int n = sum/c;
        int m = sum%c;
        int res = Integer.MAX_VALUE;

        int k1 = a/c;

        for (int i = k1; i <= k1+1; i++) {
            for (int j = 0; j <= m; j++) {
                int a1 = i*c + j;
                int b1 = sum - a1;
                if(a1%c + b1%c >= c) continue;
                int tmp = Math.abs(a-a1)+Math.abs(b-b1);
                res = Math.min(res, tmp);
            }
        }
        System.out.println(res);
    }

}

