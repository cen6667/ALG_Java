package weekly_competition.M_5;

import java.util.Scanner;

/*
3 3
3 2 1

*/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                long sum = ((long) arr[i]) *((long)arr[j]);
                if(sum>=k) res+=2;
            }
        }

        System.out.println(res);
    }

}
