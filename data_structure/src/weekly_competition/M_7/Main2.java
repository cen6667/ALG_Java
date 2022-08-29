package weekly_competition.M_7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
5
2 -4 -1 3 6

5
2 0 -1 3 6

4
13 12 11 14

*/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            set.add(arr[i]);
        }
        // arr是有饮料杯子的索引
        Arrays.sort(arr);

        int res = Integer.MAX_VALUE;
        // 以这个数为头长n的连续序列，不同的数量
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            int num = arr[i];
            for (int j = 0; j < n; j++) {
                int numj = num+j;
                if(!set.contains(numj)) tmp++;
            }
            res = Math.min(res, tmp);
        }

        // 改进：最大连续数量的第一个索引做排序O(n)，这个思路不对
//        int max = 1;
//        int count = 1;
//        int index = 0;
//        for (int i = 1; i < n; i++) {
//            if(arr[i] > arr[i-1]){
//                count++;
//            }else {
//                count = 1;
//            }
//
//            if(max < count){
//                index = i-count+1;
//                max = count;
//            }
//
//        }
//        int num = arr[index];
//        int res = 0;
//        for (int j = 0; j < n; j++) {
//            int numj = num+j;
//            if(!set.contains(numj)) res++;
//        }
        System.out.println(res);
    }


}
