package com_base.back_track_demo.combinationSum.LT_40_combinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 排序
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        boolean[] flag = new boolean[candidates.length];
        backtracking(candidates, target, 0, 0, flag);
        return result;
    }

    public void backtracking(int[] candidates, int target, int startIndex, int sum, boolean[] flag){
        if (sum == target) {
            result.add(new ArrayList(path));
            return;
        }
        for (int i = startIndex; i < candidates.length && candidates[i] + sum <= target; i++) {
            //出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && !flag[i - 1]) {
                continue;
            }
            flag[i] = true;
            sum += candidates[i];
            path.push(candidates[i]);
            //每个节点仅能选择一次，所以从下一位开始
            backtracking(candidates, target, i + 1, sum, flag);
            int temp = path.pop();
            flag[i] = false;
            sum -= temp;
        }
    }


    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        Solution sl = new Solution();

        System.out.println(sl.combinationSum2(candidates, target));
    }
}
