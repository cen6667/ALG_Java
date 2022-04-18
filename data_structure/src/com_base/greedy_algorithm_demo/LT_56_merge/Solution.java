package com_base.greedy_algorithm_demo.LT_56_merge;

import java.util.Arrays;
import java.util.LinkedList;

//左右边界排序都可以
public class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        res.add(intervals[0]);
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= res.getLast()[1]) {
                int start = res.getLast()[0];
                int end = Math.max(intervals[i][1], res.getLast()[1]);
                res.removeLast();
                res.add(new int[]{start, end});
            }
            else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        //[[1,3],[2,6],[8,10],[15,18]]
        int[][] nums = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Solution sl = new Solution();
        for (int[] i :sl.merge(nums)){
            System.out.print(Arrays.toString(i));
            System.out.print(',');
        }
    }
}
