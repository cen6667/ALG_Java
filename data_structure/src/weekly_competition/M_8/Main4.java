package weekly_competition.M_8;

import java.util.Scanner;

/*
3
1 3 4

3
3 3 3

5
-1 1 2 5 7

4
-1 1 2 5

*/
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(helper(arr));
    }

    public static int helper(int[] arr){
        int n = arr.length;
        if(n==2) return 0;

        int[] dif = new int[n-1];
        int max = 0;
        int maxIndex = 0;
        for(int i =0; i<n-1; i++){
            dif[i] = arr[i+1] - arr[i];
            if(dif[i] > max){
                max = dif[i];
                maxIndex = i;
            }
        }

        if(maxIndex == 0) dif[0] = 0;
        else if(maxIndex == n-2) dif[n-2] = 0;
        else{
            int sum = dif[maxIndex-1]+dif[maxIndex];
            dif[maxIndex] = sum/2;
            dif[maxIndex-1] = sum - dif[maxIndex];
        }

        int res = 0;
        for (int i = 0; i < dif.length; i++) {
            res = Math.max(res, dif[i]);
        }
        return res;


    }

}
