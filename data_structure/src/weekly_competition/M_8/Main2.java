package weekly_competition.M_8;

import java.util.Scanner;

/*
3
1 1 1
2 3 2
1 5 2

*/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            int y = sc.nextInt();
            int o = sc.nextInt();
            int u = sc.nextInt();
            sc.nextLine();
            System.out.println(helper(y,o,u));
        }
    }

    public static int helper(int y, int o, int u){
        int min = Math.min(y,Math.min(o,u));
        int od = o - min;
        if(od>=2) return min*2 + od-1;
        return min*2;
    }

}
