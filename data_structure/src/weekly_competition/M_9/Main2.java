package weekly_competition.M_9;

import java.util.Scanner;

/*
3 3
-1 0 -1
100 0 0
0 50 70

4 3
-1 0 -1
0 -1 0
50 100 70
80 200 50

*/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        System.out.println(helper(arr));

    }

    public static int helper(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        for (int i = 0; i < m; i++) {
            if(arr[n-1][i] == -1){
                arr[n-1][i] = 0;
            }
        }

        for (int i = n-2; i >= 1; i--) {
            for (int j = 0; j < m; j++) {
                int num = arr[i][j];
                if(num == -1){
                    if(j == 0){
                        arr[i][j] = arr[i+1][j+1];
                    }else if (j==m-1){
                        arr[i][j] = arr[i+1][j-1];
                    }else {
                        arr[i][j] = Math.max(arr[i+1][j-1], arr[i+1][j+1]);
                    }
                }else {
                    arr[i][j] += arr[i+1][j];
                }
            }
        }
        int res = 0;
        for (int j = 0; j < m; j++) {
            int num = arr[0][j];
            int i = 0;
            int sum = 0;
            if(num == -1){
                if(j == 0){
                    sum += arr[i+1][j+1];
                }else if (j==m-1){
                    sum += arr[i+1][j-1];
                }else {
                    sum += Math.max(arr[i+1][j-1], arr[i+1][j+1]);
                }
            }else {
                sum += arr[i+1][j];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
