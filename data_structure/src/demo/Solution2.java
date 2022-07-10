package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2 {
    public static void main(String[] args) {
        Solution2 sl = new Solution2();
        String a = "23";
        System.out.println(sl.letterCombinations(a));
    }
    private static Map<String,String> map = new HashMap();

    static{
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
    }

    List<String> resultList = new ArrayList();

    public List<String> letterCombinations(String digits) {
        if(digits.equals("") || digits == null) return resultList;
        append(digits, 0, new StringBuffer());
        return resultList;
    }

    public void append(String digits, int index, StringBuffer s){
        // 输出
        if(index == digits.length()){
            resultList.add(s.toString());
            return;
        }

        String v = map.get(String.valueOf(digits.charAt(index)));

        // 循环,for是纵向循环
        for(int i = 0; i<v.length(); i++){
            append(digits,index+1, s.append(v.charAt(i)));
            s.deleteCharAt(s.length() - 1);
        }

    }
}