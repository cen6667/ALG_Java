package weekly_competition.M_9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/*
3
5 2
abcda
01110
7 2
abbaccb
1001001
3 0
aab
101

*/
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int j = 0; j < t; j++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            String strarr = sc.nextLine();

            char[] chars = new char[n];
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if(strarr.charAt(i) == '1'){
                    arr[i] = 1;
                }
                chars[i] = str.charAt(i);
            }

            System.out.println(helper(chars, arr, m));
        }
    }

    public static int helper(char[] chars, int[] arr, int m){
        int res = 1;
        int n = chars.length;
        int left = 0, right = 0;
        int count = 0;
        char pre = chars[left];
        while (right < n-1){
            // 结果
            if(chars[right] == pre || arr[right] == 1 || pre == ' '){
                res = Math.max(res, right-left+1);
            }
            // 右加一
            right++;
            if(arr[right] == 1) count++;
            // 不符合条件
            while (count>m){
                if(arr[left] == 1) count--;
                left++;
                if(left<n && arr[left] != 1){
                    pre = chars[left];
                }else {
                    pre = ' ';
                }
            }
        }

        return res;
    }
}
