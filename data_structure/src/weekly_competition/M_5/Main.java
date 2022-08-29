package weekly_competition.M_5;

import java.util.Scanner;

/*
n、m和id
3 3 2
90 90 90
80 100 90
80 85 85

*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int id = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += sc.nextInt();
            }
            arr[i] = sum;
            sc.nextLine();
        }
        int idSum = arr[id-1];
        int res = 1;
        for (int i = 0; i < n; i++) {
            if(arr[i]>idSum){
                res++;
            }
            if(arr[i]==idSum && i<id-1) res++;
        }
        System.out.println(res);
    }

}
