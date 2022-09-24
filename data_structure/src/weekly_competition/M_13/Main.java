package weekly_competition.M_13;

import java.util.*;

/*
5
red
hash
yes
no
foo

*/
public class Main {
    public static Set<Character> set = new HashSet<>(){{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
    }};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            boolean flag = helper(sc.nextLine());
            if(flag){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }

    public static Boolean helper(String str){
        if(str.length() != 3) return false;

        if(set.contains(str.charAt(0))) return false;
        if(!set.contains(str.charAt(1))) return false;
        if(set.contains(str.charAt(2))) return false;

        return true;
    }

}
