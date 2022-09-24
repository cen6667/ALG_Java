package weekly_competition.M_11;

import java.util.Arrays;
import java.util.Scanner;

/*
4
3 6
16 2
48 4
1024 1

*/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sc.nextLine();
            System.out.println(helper(a, b));
        }

    }

    public static int helper(int a, int b){
        if(a<b) {
            int tmp = b;
            b = a;
            a = tmp;
        }
        if(a%b != 0) return -1;
        int res = 0;
        int n = a/b;
        if(n==1) return 0;
        if(n%2 != 0) return -1;
        while (n%8 == 0){
            res++;
            n = n/8;
            if(n%2 != 0 && n != 1) return -1;
        }
        if (n%4 == 0){
            res++;
            n = n/4;
            if(n%2 != 0 && n != 1) return -1;
        }
        if (n%2 == 0){
            res++;
            n = n/2;
            if(n%2 != 0 && n != 1) return -1;
        }

        return res;

    }
}
