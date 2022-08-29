package weekly_competition.M_6;

import java.util.Scanner;

/*
3 3 2

4 4 3

*/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = maxCommonDivisor(i+1, j+1);
            }
        }
        int res = 0;
        for (int i = 0; i < n - k + 1; i++) {
            for (int j = 0; j < n - k + 1; j++) {
                // k*k求和
                for (int l = i; l < i + k; l++) {
                    for (int o = j; o < j + k; o++) {
                        res += arr[l][o];
                    }
                }
            }
        }

        System.out.println(res);
    }

    public static int maxCommonDivisor(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

}
