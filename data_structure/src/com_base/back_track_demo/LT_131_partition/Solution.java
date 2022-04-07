package com_base.back_track_demo.LT_131_partition;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<String>> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return result;

    }

    public void backTracking(String s, int startindex) {
        if (startindex >= s.length()) {
            result.add(new ArrayList(path));
            return;
        }
        for (int i = startindex; i < s.length(); i++) {
            //如果是回文子串，则记录
            if (isPalindrome(s, startindex, i)) {
                String str = s.substring(startindex, i + 1);
                path.addLast(str);
            } else {
                continue;
            }

            backTracking(s, i+1);
            path.pollLast();

        }

    }

    //判断是否是回文串
    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String num = "aab";

        Solution sl = new Solution();

        System.out.println(sl.partition(num));
    }
}
