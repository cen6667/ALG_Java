package com_base.greedy_algorithm_demo.LT_406_reconstructQueue;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {

    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
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

        LinkedList<int[]> que = new LinkedList<>();
        //按顺序放入时，可放心按照后面数字插入位置
        for (int[] p : people) {
            que.add(p[1],p);
        }

        return que.toArray(new int[people.length][]);
    }


    public static void main(String[] args) {
        int[][] nums = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        Solution sl = new Solution();
        for (int[] i :sl.reconstructQueue(nums)){
            System.out.print(Arrays.toString(i));
            System.out.print(',');
        }
    }
}
