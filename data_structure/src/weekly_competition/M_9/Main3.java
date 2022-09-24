package weekly_competition.M_9;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*
4
3
-1 0 1
5
1 -2 -2 1 -3
6
0 0 0 0 0 0
4
-1 2 -3 4

*/
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        for (int j = 0; j < m; j++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }

            if(helper(arr)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
            sc.nextLine();
        }
    }

    public static boolean helper(int[] arr){
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i:arr){
            set.add(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if(!set.contains(sum)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
