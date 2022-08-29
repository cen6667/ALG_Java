package weekly_competition.M_5;

import java.util.Arrays;
import java.util.Scanner;

/*
6
1 2 2 3 3

7
1 1 1 1 1 1

8
1 2 3 4 5 6 7

*/
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n-1];
        for(int i = 0; i < n-1; i++){
            arr[i] = sc.nextInt();
        }
        int count = 0;
        Arrays.sort(arr);

        int cur = arr[0];
        for (int i = 1; i < n-1; i++) {
            if(cur == arr[i]) {
                count++;
            }
            cur = arr[i];
        }
        System.out.println((n-count)/2);
    }

}
