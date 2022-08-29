package weekly_competition.M_3;

import java.util.Scanner;

/*
3 3 3
i you he
am is are
yours his hers
5
i am yours
you is his
he are hers yours
i am am yours
is his

*/
public class Main2 {
    static String[] strs1;
    static String[] strs2;
    static String[] strs3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        sc.nextLine();

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String str3 = sc.nextLine();

        strs1 = str1.split(" ");
        strs2 = str2.split(" ");
        strs3 = str3.split(" ");

        int n = sc.nextInt();
        sc.nextLine();
        String str;
        for(int i = 0; i < n; i++){
            str = sc.nextLine();
            String[] strs = str.split(" ");
//            System.out.println(str);

            if(helper(strs)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }

        }

    }

    public static boolean helper(String[] strs){
        int index = 0;
        while (true){
            if(isHave(strs1,strs[index])){
                index++;
            }else break;
        }
        // 如果没有主语，直接报错
        if(index == 0) return false;
        int tmp = index;
        while (true){
            if(isHave(strs2,strs[index])){
                index++;
            }else break;
        }
        // 如果谓语没有或者多于一个，直接报错
        if(index-tmp != 1) return false;


        return true;

    }

    public static boolean isHave(String[] strs, String str){
        int i = strs.length;
        while (i-->0){
            if(strs[i].equals(str)){
                return true;
            }
        }
        return false;
    }

}
