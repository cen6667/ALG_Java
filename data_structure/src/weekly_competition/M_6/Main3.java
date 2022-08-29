package weekly_competition.M_6;

import java.util.Arrays;
import java.util.Scanner;

/*
5 4
3 2 1 5 6
8 1 4 2 3
1 1
1 2
2 1
1 10

1 4
5
8
1 1
1 2
2 1
1 10

*/
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        // 我的伤害
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        sc.nextLine();
        // 对手伤害
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < q; i++) {
            int q1 = sc.nextInt();
            int q2 = sc.nextInt();
            sc.nextLine();
            int res = 0;

            for (int j = 0; j < n; j++) {
                int m = arr1[n - j - 1] * q1;
                int s = arr2[j] * q2;
                if(m>s) res += m-s;
                else break;
            }
            System.out.println(res);
        }

    }
}
