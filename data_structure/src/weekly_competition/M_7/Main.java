package weekly_competition.M_7;

import java.util.Arrays;
import java.util.Scanner;

/*
3
3
66 66 66
99 70 60
4
99 10 60 25
43 49 43
6
46 64 0 100 60 88
62 88 77

*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            sc.nextLine();
            int[] arr1 = new int[n];
            for (int i = 0; i < n; i++) {
                arr1[i] = sc.nextInt();
            }
            sc.nextLine();
            int[] arr2 = new int[3];
            for (int i = 0; i < 3; i++) {
                arr2[i] = sc.nextInt();
            }

            if(helper(n, arr1, arr2)){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }


    }

    public static boolean helper(int n, int[] arr1, int[] arr2){
        // 中位数
        Arrays.sort(arr1);
        int mid;
        if(n%2==0){
            mid = (arr1[n/2-1]+arr1[n/2])/2;
        }else {
            mid = arr1[n/2];
        }
        if(mid >= arr2[0]) return true;

        // 平均数
        int sum = 0;
        for (int i : arr1) {
            sum += i;
        }
        if(sum/n >= arr2[1]) return true;

        // 去最高最低平均数
        int x = arr1[0];
        int y = arr1[n-1];
        int tmp = (sum-x-y)/(n-2);
        if(tmp >= arr2[2]) return true;

        return false;
    }
}
