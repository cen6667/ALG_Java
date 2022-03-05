package com_base.hash_map_demo.test_demo.LT_1002;

import java.util.ArrayList;
import java.util.List;

// 找出每个单词的哈希表，进行对比，取出最少的哈希。可以初始化，然后一次一次覆盖
public class Solution2 {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        if (words.length == 0) return result;
        int[] hash = new int[26]; // 用来统计所有字符串里字符出现的最小频率
        for (int i = 0; i < words[0].length(); i++) { // 用第一个字符串给hash初始化
            hash[words[0].charAt(i) - 'a']++;
        }
        // 统计除第一个字符串外字符的出现频率
        for (int i = 1; i < words.length; i++) {
            int[] hashOtherStr = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                hashOtherStr[words[i].charAt(j) - 'a']++;
            }
            // 更新hash，保证hash里统计26个字符在所有字符串里出现的最小次数
            for (int k = 0; k < 26; k++) {
                hash[k] = Math.min(hash[k], hashOtherStr[k]);
            }
        }
        // 将hash统计的字符次数，转成输出形式
        for (int i = 0; i < 26; i++) {
            while (hash[i] != 0) { // 注意这里是while，多个重复的字符
                char c = (char) (i + 'a');
                result.add(String.valueOf(c));
                hash[i]--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2 sl = new Solution2();
        String[] words1 = {"bella", "label", "roller"};
        List<String> result1 = sl.commonChars(words1);
        System.out.println(result1);

        String[] words2 = {"cool", "lock", "cook"};
        List<String> result2 = sl.commonChars(words2);
        System.out.println(result2);

        String[] words3 = {"acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"};
        List<String> result3 = sl.commonChars(words3);
        System.out.println(result3);
    }
}
