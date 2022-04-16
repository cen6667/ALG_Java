package com_base.greedy_algorithm_demo.LT_435_eraseOverlapIntervals;

import java.util.Arrays;

//左右边界排序都可以
public class Solution {
    public int eraseOverlapIntervals2(int[][] intervals) {
        //左边界排序
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        int remove = 0;
        int pre = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (pre > intervals[i][0]) {
                remove++;
                pre = Math.min(pre, intervals[i][1]);
            } else pre = intervals[i][1];
        }
        return remove;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        //右边界排序
        int count = 1;
        // 身高从大到小排（身高相同k小的站前面）
        // 写的排序语句，不要超过了int的范围
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        // 保存上一个区间
        int[] pre_section = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (pre_section[1] <= intervals[i][0]) {
                count++;
                pre_section[1] = intervals[i][1];
            }
        }
        return intervals.length - count;
    }


    public static void main(String[] args) {
        //[[1,100],[11,22],[1,11],[2,12]]
        int[][] nums = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
//        int[][] nums = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
//        int[][] nums = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
//        int[][] nums = {{9,12}, {1,10}, {4,11}, {8,12}, {3,9}, {6,9}, {6,7}};
        Solution sl = new Solution();
        System.out.println(sl.eraseOverlapIntervals(nums));
    }
}
