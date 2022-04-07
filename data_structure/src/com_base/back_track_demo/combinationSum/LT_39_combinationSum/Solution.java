package com_base.back_track_demo.combinationSum.LT_39_combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0, 0);
        return result;
    }

    public void backtracking(int[] candidates, int target, int startIndex, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList(path));
            return;
        }
        for (int i = startIndex == 0 ? 0 : startIndex - 1; i < candidates.length; i++) {

            sum += candidates[i];
            path.push(candidates[i]);

            backtracking(candidates, target, i + 1, sum);
            int temp2 = path.pop();
            sum -= temp2;
        }
    }


    public static void main(String[] args) {
        int[] candidates = {2, 7, 6, 3, 5, 1};
        int target = 9;

        Solution sl = new Solution();

        System.out.println(sl.combinationSum(candidates, target));
    }
}
