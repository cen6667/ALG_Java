package weekly_competition.M_8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
7
rgbrgbg
1 2
2 3
3 4
4 5
5 6
6 7

*/
public class Main3 {
    public static Map<Integer, Integer> leftMap = new HashMap<>();
    public static Map<Integer, Integer> rightMap = new HashMap<>();
    public static Map<Character, Integer> resMap = new HashMap<>();
    public static Map<Character, Integer> map = new HashMap<>();
    public static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
            resMap.put(c,0);
        }

        int[][] arr = new int[n][2];

        for (int i = 0; i < n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[i][0] = a;
            arr[i][1] = b;
            sc.nextLine();
            if(!leftMap.containsKey(a)){
                leftMap.put(a,b);
            }else {
                rightMap.put(a,b);
            }
        }
        helper(1, s);
        System.out.println(res);

    }

    public static void helper(int root, String s){
        if(leftMap.getOrDefault(root,-1) != -1) {
            helper(leftMap.get(root), s);
        }
        if(rightMap.getOrDefault(root,-1) != -1) {
            helper(rightMap.get(root), s);
        }
        char c = s.charAt(root-1);
        resMap.put(c, resMap.get(c)+1);
        map.put(c, map.get(c)-1);
        boolean flag = true;
        for(int i:map.values()){
            if(i==0){
                flag = false;
                break;
            }
        }
        for(int i:resMap.values()){
            if(i==0){
                flag = false;
                break;
            }
        }
        if(flag) res++;
    }

}
