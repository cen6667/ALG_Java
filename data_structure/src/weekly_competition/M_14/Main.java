package weekly_competition.M_14;

import java.lang.reflect.Array;
import java.util.*;

/*
7 1
3 6 1 7 2 5 4

10 2
4 8 9 10 7 6 5 3 2 1

*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        sc.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(helper(arr, m));
    }

    public static String helper(int[] arr, int m) {
        int n = arr.length;
        int[] used = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        boolean flag = true;
        while (!map.isEmpty()){
            int num = map.firstKey();
            int index = map.get(num);
            map.remove(num);
            int use = flag?1:2;
            used[index] = use;

            int left = index-1;
            int count = m;
            while (left >= 0 && count>0){
                if(used[left]==0){
                    used[left] = use;
                    count--;
                    map.remove(arr[left]);
                }
                left--;
            }

            int right = index+1;
            count = m;
            while (right < n && count>0){
                if(used[right]==0){
                    used[right] = use;
                    count--;
                    map.remove(arr[right]);
                }
                right++;
            }

            flag = !flag;
        }
        StringBuilder res = new StringBuilder();
        for(int i:used){
            if(i == 1){
                res.append('A');
            }else {
                res.append('B');
            }
        }
        return res.toString();
    }

}
