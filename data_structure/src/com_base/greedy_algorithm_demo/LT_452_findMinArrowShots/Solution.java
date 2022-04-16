package com_base.greedy_algorithm_demo.LT_452_findMinArrowShots;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int findMinArrowShots2(int[][] points) {
        //答案，比我还慢
        //不一样的地方
        // 1.排序简单一些
        // 2.没有保存区间，直接修改原数据
        // 3.min代替if判断（这里可能很慢）
        if (points.length == 0) return 0;
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                count++;
            } else {
                points[i][1] = Math.min(points[i][1],points[i - 1][1]);
            }
        }
        return count;
    }

    public int findMinArrowShots(int[][] points) {
        if(points.length==1) return 1;

        int count = 1;
        // 身高从大到小排（身高相同k小的站前面）
        // 写的排序语句，不要超过了int的范围
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                if(a[1] >= b[1]) return 1;
                else return -1;
            }
            else if(a[0] > b[0]) return 1;
            else return -1;
        });
        //Lambda表达式为Comparator接口进行实例化，自定义排序规则
//        public static <T> void sort(T[] a, Comparator<? super T> c) {
//            if (c == null) {
//                sort(a);
//            } else {
//                if (Arrays.LegacyMergeSort.userRequested)
//                    legacyMergeSort(a, c);
//                else
//                    TimSort.sort(a, 0, a.length, c, null, 0, 0);
//            }
//        }

//        降序排列：obj1-obj2>0的话返回-1，说明按照从大到小排序b-a
//        升序排列：obj1-obj2>0的话返回1，说明按照从小到大排序a-b
        // 保存上一个区间
        int[] pre_section = new int[2];
        //copy数组
        System.arraycopy(points[0],0,pre_section,0,2);

        for (int i = 1; i < points.length; i++) {
            if (pre_section[1] < points[i][0]) {
                //没有交集
                count++;
                pre_section = points[i];
            }else if (pre_section[1] < points[i][1]){
                //有交集[1,3] [2,10]
                pre_section[0] = points[i][0];
            }else {
                //这种情况不要忘[1,10] [2,9]
                pre_section = points[i];
            }
        }
        return count;
    }


    public static void main(String[] args) {
//        int[][] nums = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
//        int[][] nums = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        //[[-2147483646,-2147483645],[2147483646,2147483647]]
//        int[][] nums = {{-2147483646,-2147483645},{2147483646,2147483647}};
        //[[9,12],[1,10],[4,11],[8,12],[3,9],[6,9],[6,7]]
        int[][] nums = {{9,12}, {1,10}, {4,11}, {8,12}, {3,9}, {6,9}, {6,7}};
        Solution sl = new Solution();
        System.out.println(sl.findMinArrowShots(nums));
    }
}
