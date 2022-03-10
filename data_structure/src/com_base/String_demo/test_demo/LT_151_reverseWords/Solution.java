package com_base.String_demo.test_demo.LT_151_reverseWords;

class Solution {
    /**
     * 不使用Java内置方法实现
     * <p>
     * 1.去除首尾以及中间多余空格
     * 2.反转整个字符串
     * 3.反转各个单词
     */
    public String reverseWords(String s) {
        // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
        // 1.去除首尾以及中间多余空格，空间复杂度n，时间复杂度n
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串，空间复杂度n，时间复杂度n
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词，空间复杂度n，时间复杂度n
        reverseEachWord(sb);
        return sb.toString();
    }

    private StringBuilder removeSpace(String s) {
        // 去除开头结尾空格
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;

        // 赋值
        StringBuilder res = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            // 很经典
            if (c != ' ' || res.charAt(res.length() - 1) != ' ') {
                res.append(c);
            }
            start++;
        }
        return res;
    }

    private void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    private void reverseEachWord(StringBuilder sb) {
        int fast = 0;
        int slow = 0;
        while (fast < sb.length()-1) {
            if (sb.charAt(fast+1) == ' ' ) {
                reverseString(sb, slow, fast);
                slow = fast + 2;
            }
            fast++;
        }
        reverseString(sb, slow, fast);
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        String s = "  the  sky    is  blue       ";
        String res = sl.reverseWords(s);
        System.out.println(res);
    }
}