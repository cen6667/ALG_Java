package weekly_competition.M_10;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 翻牌
     * @param inHand string字符串 一组以单空格间隔的手牌(例如：SA HK H9 D8 C5 S5 H4)
     * @return string字符串
     */
    public static String showDown (String inHand) {
        // write code here
        String[] strs = inHand.split(" ");
        for (int i = 0; i < strs.length; i++) {

        }
        System.out.println(strs);
        return "q";
    }

    public static void main(String[] args) {
        String str = "SA SK SQ SJ S10 H10 C9";
        System.out.println(showDown(str));
    }
}