package demo.demo;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.movingCount(1,2, 3));
    }

    private int res = 0;

    public int movingCount(int threshold, int rows, int cols) {
        if (rows <= 0 || cols <= 0 || threshold < 0)
            return 0;
        boolean[][] arr = new boolean[rows][cols];
        dfs(threshold, arr, 0, 0);
        return res;
    }

    private void dfs(int threshold, boolean[][] arr, int i, int j){
        // 边界条件
        int sum = sumNum(i) + sumNum(j);
        if(i >= arr.length || i<0 ||
                j >= arr[0].length || j < 0 ||
                sum > threshold || arr[i][j]){
            return;
        }else if

        // 计数
        res++;
        arr[i][j] = true;

        // 递归
        dfs(threshold, arr, i+1, j);
        dfs(threshold, arr, i-1, j);
        dfs(threshold, arr, i, j+1);
        dfs(threshold, arr, i, j-1);
    }

    private int sumNum(int i){
        int sum = i%10;
        while(i/10 !=0){
            i = i/10;
            sum += i%10;
        }
        return sum;
    }


}