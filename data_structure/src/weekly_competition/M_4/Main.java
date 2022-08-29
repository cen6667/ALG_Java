package weekly_competition.M_4;

import java.util.Scanner;
/*
5 3
aBcBa

*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        System.out.println(helper(n,k,str));
    }

    public static String helper(int n, int k, String str){
        StringBuffer sb = new StringBuffer();
        String sk = str.substring(0,k);

        sb.append(sk.toUpperCase());
        sk = str.substring(k);

        sb.append(sk.toLowerCase());
        return sb.toString();
    }

}
