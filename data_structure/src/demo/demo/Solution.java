package demo.demo;

import java.util.*;

class RangeModule {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "aobeidbaooo";
        /*
"abcabcbb"
"bbbbb"
"pwwkew"*/
        String s = "pwwkew";

        System.out.println(lengthOfLongestSubstring(s));
    }

    /* 3 */
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;

        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 增大窗口
            right++;
            // 进行窗口内数据的一系列更新
            window.put(c, window.getOrDefault(c, 0)+1);

            // 先扩大window到包含所有字符，再判断左侧窗口是否要收缩
            while (window.get(c) > 1) {
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                window.put(d, window.getOrDefault(d, 0)-1);
            }
            //结果
            res = Math.max(res, right-left);
        }
        return res;
    }

    /* 438 */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 填充need
        char[] sc = p.toCharArray();
        for(char c: sc){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left=0, right=0;
        //保证window里每个need字符存在
        int valid = 0;

        //滑动窗口
        while (right<s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c))){
                    // t中重复字符也必须被一一对应
                    valid++;
                }
            }
            // 先扩大window到包含所有字符，再判断左侧窗口是否要收缩
            while (right - left > p.length()) {
                // 在这里判断是否找到了合法的子串
                if (valid == need.size()){
                    res.add(left);
                }

                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) valid--;
                    window.put(d, window.getOrDefault(d, 0)-1);
                }
            }
        }
        return res;
    }

    /* 567 */
    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 填充need
        char[] sc = s1.toCharArray();
        for(char c: sc){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left=0, right=0;
        //保证window里每个need字符存在
        int valid = 0;

        //滑动窗口
        while (right<s2.length()){
            char c = s2.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c))){
                    // t中重复字符也必须被一一对应
                    valid++;
                }
            }
            // 先扩大window到包含所有字符，再判断左侧窗口是否要收缩
            while (right - left >= s1.length()) {
                // 在这里判断是否找到了合法的子串
                if (valid == need.size())
                    return true;
                // d 是将移出窗口的字符
                char d = s2.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) valid--;
                    window.put(d, window.getOrDefault(d, 0)-1);
                }
            }
        }
        return false;
    }

    /* 76 */
    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] tarry = t.toCharArray();
        for (char c : tarry) {
            need.put(c, need.getOrDefault(c, 0)+1);
        }

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 增大窗口
            right++;
            // 进行窗口内数据的一系列更新
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if(window.get(c).equals(need.get(c))){
                    // t中重复字符也必须被一一对应
                    valid++;
                }
            }

            /*** debug 输出的位置 ***/
            System.out.printf("window: [%d, %d)\n", left, right);
            /********************/

            // 先扩大window到包含所有字符，再判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) valid--;

                    window.put(d, window.getOrDefault(d, 0)-1);
                }
            }
            System.out.printf("result: [%d, %d)\n", start, start+len);
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }
}
