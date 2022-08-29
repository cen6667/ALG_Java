package weekly_competition.M_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
6
1 1 4 5 1 4

*/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(helper2(n,arr));
    }

    public static int helper2(int n,int[] arr){
        int res1 = 0;
        int res2 = 0;
        int[] arr1;
        if(n%2 == 0){
            arr1 = new int[n/2];
        }else {
            arr1 = new int[n/2+1];
        }
        int[] arr2 = new int[n/2];

        for (int i = 0; i <= n / 2; i++) {
            if(i*2>=n) break;
            arr1[i] = arr[i*2];
        }
        for (int i = 0; i < n / 2; i++) {
            arr2[i] = arr[i*2+1];
        }
        res1 = helper(arr1);
        res2 = helper(arr2);

        return res1 + res2;
    }

    public static int helper(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        int count = 0;
        for(int value : map.values()){
            count = Math.max(count, value);
        }

        return arr.length - count;
    }

}
