package com_base.hash_map_demo.test_demo.LT_1002;

import java.util.ArrayList;
import java.util.List;
// 完全错误，不能整体去比较，还是要分单词
public class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int length_w = words.length;
        int[] table = new int[26];
        for (String st : words) {
            for (char c : st.toCharArray()) {
                table[c - 'a'] += 1;
            }
        }
        for (int index = 0; index < 26; index++) {
            int i = table[index];
            for (int j = 0; j < i / length_w; j++) {
                char r = (char) (index + 'a');
                result.add(String.valueOf(r));
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
//        String[] words = {"bella", "label", "roller"};
//        String[] words = {"cool","lock","cook"}; // 只要大于长度，都要输出
//        String[] words = {};
        String[] words = {"acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"};
        List<String> result = sl.commonChars(words);
        System.out.println(result);
    }
}
