package weekly_competition.M_11;

import java.util.Arrays;
import java.util.Scanner;

/*
4
123 45 678 23

*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt()+"";
        }
        System.out.println(helper(arr));
    }

    public static String helper(String[] arr){
        String[] nums = new String[3];
        Arrays.sort(arr, (a, b)->(b+""+a).compareTo(a+""+b));
        Arrays.sort(arr, (a, b)->b.length()-a.length());
        for (int i = 0; i < 3; i++) {
            nums[i] = arr[i];
        }

        Arrays.sort(nums, (a, b)->(b+""+a).compareTo(a+""+b));
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            res.append(nums[i]);
        }
        return res.toString();
    }
}
