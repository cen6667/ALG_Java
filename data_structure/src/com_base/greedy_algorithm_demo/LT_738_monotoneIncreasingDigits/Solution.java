package com_base.greedy_algorithm_demo.LT_738_monotoneIncreasingDigits;


public class Solution {

    public int monotoneIncreasingDigits(int n) {
        if (n == 0) return 0;
        char[] sarr = (n + "").toCharArray();
        //记录需要变9的位置，这个位置之后的数字都需要变成9
        int start=Integer.MAX_VALUE;//start初始值设为最大值，这是为了防止当数字本身是单调递增时，没有一位数字需要改成9的情况
        for (int i = sarr.length - 1; i > 0; i--) {
            if (sarr[i - 1] > sarr[i]) {
                sarr[i - 1] -= 1;
                start = i;
            }
        }
        int result = 0;
        for (int i = 0; i < sarr.length; i++) {
            if(i>=start){
                result = result * 10 + 9;
            } else result = result * 10 + (sarr[i] - '0');
        }
        return result;
    }

    public static void main(String[] args) {
//        int num = 332;
        int num = 100;
        Solution sl = new Solution();
        System.out.println(sl.monotoneIncreasingDigits(num));
    }
}
