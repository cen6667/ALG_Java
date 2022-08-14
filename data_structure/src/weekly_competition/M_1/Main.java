package weekly_competition.M_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            sc.nextLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

    }

    public static void helper(int[][] arr){
        int n = arr.length;
        int[] res = new int[n*n];
//        int COUNT = n*n;
//        int count = n*n;

        int flag = n+n-1;

        int i=0, j=0;

        for (int k = 0; k<flag; k++){
            if(k%2 == 0){
                while (i >= 0 && j < n){
                    System.out.print(arr[i][j]+" ");
                    i--;
                    j++;
                }
                i++;
                if(j>=n){
                    j = n-1;
                    i = i+1;
                }
            }
            if(k%2 != 0){
                while (i < n && j >= 0){
                    System.out.print(arr[i][j]+" ");
                    i++;
                    j--;
                }
                j++;
                if(i>=n){
                    i = n-1;
                    j = j+1;
                }
            }

        }
    }
}
