package com_base.greedy_algorithm_demo.LT_763_partitionLabels;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();
        int[] edge = new int[26];//字母hash
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 统计每一个字符最后出现的位置
            edge[chars[i]-'a'] = i;
        }
        int idx = 0;
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            idx = Math.max(idx,edge[chars[i] - 'a']);// 找到字符出现的最远边界
            if (i == idx) {
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String nums = "ababcbacadefegdehijhklij";
        Solution sl = new Solution();
        System.out.println(sl.partitionLabels(nums));
    }
}
