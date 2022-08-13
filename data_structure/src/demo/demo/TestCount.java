package demo.demo;

/**
 * @author zyc
 * @description: 测试
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class fa {
    private String name;
    public fa(){
        System.out.println("父类");
    }
    public fa(String name){
        System.out.println("父类"+name);
    }
}

class zi extends fa{
    public zi(){
        System.out.println("子类");
    }
}

public class TestCount {
    public static void main(String[] args) {
        new fa();
        new zi();
//        String s = "abcdefgio";
//        String g = "if go and";
//        int[] arr = new int[26];
//        char[] ch = s.toCharArray();
//        for (char c : ch) {
//            arr[c-97]++;
//        }
//        System.out.println(Arrays.toString(arr));
//        String[] g1 = g.split(" ");
//
//
//        int res = 0;
//        for(int i = 0;i< g1.length;i++) {
//            String s1 = g1[i];
//            char[] chs1 = s1.toCharArray();
//            boolean flag = true;
//            for (char chs : chs1) {
//                if(arr[chs-'a'] <= 0){
//                    flag = false;
//                }else {
//                    arr[chs-'a']--;
//                }
//            }
//            if(flag) res++;
//        }
//
//        System.out.println(res);


    }
}

