package com_base.back_track_demo.combinationSum.LT_216_combinationSum3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n, k, 1, 0);
        return result;
    }

    public void backtracking(int targetSum, int k, int startIndex, int sum){
        // 减枝
        if (sum > targetSum) {
            return;
        }
        //终止条件
        if (path.size() == k){
            if(sum == targetSum)
                result.add(new ArrayList<>(path));
            return;
        }
        // 题目只使用数字1到9，减枝 9 - (k - path.size()) + 1
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtracking(targetSum, k, i + 1, sum);
            sum -= i;
            path.removeLast();
        }
    }


    public static void main(String[] args) {

        Solution sl = new Solution();

        System.out.println(sl.combinationSum3(4,16));
    }
}
