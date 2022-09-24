package weekly_competition.M_15;

import com_base.List_demo.demo.List_Arr;

import java.util.*;

/*
84 4

*/
public class Main {
    static int res = 0;
    static StringBuilder path = new StringBuilder();
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String num = n+"";
        int[] arr = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            arr[i] = num.charAt(i)-'0';
        }
        used = new boolean[num.length()];
        helper(arr, m);
        System.out.println(res);
    }

    public static void helper(int[] arr, int m) {
        if(path.length() == arr.length){
            int num = Integer.parseInt(path.toString());
            if(num%m == 0){
                res++;
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(used[i]){
                continue;
            }
            used[i] = true;
            path.append(arr[i]);
            helper(arr, m);
            path.deleteCharAt(path.length()-1);
            used[i] = false;
        }
    }

}
