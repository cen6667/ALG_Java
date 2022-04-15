package com_base.greedy_algorithm_demo.LT_860_lemonadeChange;

public class Solution {
    /**
     * 分两个阶段
     * 1、起点下标1 从左往右，只要 右边 比 左边 大，右边的糖果=左边 + 1
     * 2、起点下标 ratings.length - 2 从右往左， 只要左边 比 右边 大，此时 左边的糖果应该 取本身的糖果数（符合比它左边大） 和 右边糖果数 + 1 二者的最大值，这样才符合 它比它左边的大，也比它右边大
     */
    public boolean lemonadeChange(int[] bills) {
        if (bills[0] != 5) return false;
        int cash_5 = 0;
        int cash_10 = 0;
        for (int i : bills) {
            if (i == 5) {
                cash_5++;
            } else if (i == 10) {
                cash_5--;
                cash_10++;
            } else if (cash_10 > 0) {
                cash_10--;
                cash_5--;
            } else {
                cash_5 -= 3;
            }
            if (cash_5 < 0 || cash_10 < 0) return false;
        }
        return true;

    }


    public static void main(String[] args) {
        int[] nums = {5, 5, 5, 10, 20};
        Solution sl = new Solution();
        System.out.println(sl.lemonadeChange(nums));
    }
}
