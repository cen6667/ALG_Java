package weekly_competition.M_4;

import java.util.Scanner;

/*
6
*/
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(helper(n));
    }

    public static int helper(int n){
        if(n<6) return 0;
        if(n==6) return 1;
        long res = 1;
        for (int i = 0; i < n - 6; i++) {
            res = (long) (res*26 % 10e7);
        }
        return (int) res;
    }

}
