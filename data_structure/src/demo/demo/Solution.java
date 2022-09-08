package demo.demo;

import java.util.*;
public class Solution {
    public static void main(String[] args) {

        int e = 4296;
        int d = 1601;
        int n = 4757;
        long pow = (long) Math.pow(e,d);
        System.out.println(((int) Math.pow(e,d))%n);
    }
    public static int[] calculate(int[] nums){
        int[] res = new int[2];
        Arrays.sort(nums);
        int right = 0;
        int left = 0;
        int len = 0;
        int cur = 0;
        for(int i=1;i<nums.length;i++){
            int dif = nums[i] - nums[i-1];
            if(dif == 1){
                right++;
                len = right-left+1;
                if(cur < len){
                    cur = len;
                    res[0] = nums[left];
                    res[1] = nums[right];
                }
            }else{
                left=i;
                right=i;
            }
        }
        return res;
    }

    public static String removeOccurrences(String s, String part) {
        StringBuilder str = new StringBuilder();
        int n = part.length();
        char last = part.charAt(n-1);
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            str.append(c);
            if(c == last && str.length()>=n && str.substring(str.length()-n).equals(part)){
                int len = n;
                while(len-->0){
                    str.deleteCharAt(str.length()-1);
                }
            }
        }
        return str.toString();
    }

//    public static int[] calculate(int[] nums){
//        int[] res = new int[2];
//        Arrays.sort(nums);
//        int right = 0;
//        int left = 0;
//        int len = 1;
//        int cur = 0;
//        for(int i=1;i<nums.length;i++){
//            int dif = nums[i] - nums[i-1];
//            if(dif == 1){
//                len++;
//                right++;
//                if(cur < len){
//                    res[1] = right;
//                }
//            }else{
//                len = 1;
//
//            }
//        }
//    }
}