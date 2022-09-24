package weekly_competition.M_9;

import java.util.Scanner;

/*
8,3
1,0,1,2,1,1,7,5
0,1,0,1,0,1,0,0

*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        String[] strs = tmp.split(",");
        int n = strs[0].charAt(0) - '0';
        int m = strs[1].charAt(0) - '0';

        int[] arr = new int[n];
        int[] arr2 = new int[n];
        tmp = sc.nextLine();
        strs = tmp.split(",");
        for (int i = 0; i < n; i++) {
            arr[i] = strs[i].charAt(0) - '0';
        }
        tmp = sc.nextLine();
        strs = tmp.split(",");
        int res = 0;
        for (int i = 0; i < n; i++) {
            int num = strs[i].charAt(0) - '0';
            arr2[i] = arr[i];
            if(num > 0) {
                arr2[i] = 0;
                res += arr[i];
            }
        }
        System.out.println(res + helper(arr2, m));

    }

    public static int helper(int[] arr, int m){
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }
        int res = sum;
        for (int i = 0; i < n - m; i++) {
            sum = sum - arr[i] + arr[i+m];
            res = Math.max(res, sum);
        }
        return res;
    }
}
