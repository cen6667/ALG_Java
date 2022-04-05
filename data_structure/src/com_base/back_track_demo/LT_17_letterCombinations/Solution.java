package com_base.back_track_demo.LT_17_letterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<String> result = new ArrayList<>();
    //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuild
    StringBuilder temp = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtracking(digits, 0);
        return result;
    }

    private void backtracking(String digits, int startIndex){
        //终止条件
        if (startIndex == digits.length()){
            result.add(temp.toString());
            return;
        }
        int num = digits.charAt(startIndex) - '0';
        String str = numString[num];
        for (int i = 0; i < str.length(); i++){
            temp.append(str.charAt(i));
            backtracking(digits, startIndex + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        String num = "234";

        Solution sl = new Solution();

        System.out.println(sl.letterCombinations(num));
    }
}
