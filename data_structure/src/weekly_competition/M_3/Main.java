package weekly_competition.M_3;

import java.util.*;
/*
5
BA
aOWVXARgUbJDG#
OPPCSKNS^
HFDJEEDA
ABBABBBBAABBBAABAAA

*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strs = new String[n];
        for(int i = 0; i < n; i++){
            strs[i] = sc.nextLine();
            System.out.println(strs[i]);
        }
        int res = 0;
        for(String str:strs){
            if(filter(str)){
                res++;
            }
        }
        System.out.println(res);
    }

    public static boolean filter(String str){
        if(str.length() > 10) return false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= 'a' && c<='z'){}
            else if(c >= 'A' && c<='Z'){}
            else return false;
        }
        return true;
    }
}
