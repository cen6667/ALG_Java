package com_base.Tree_demo.demo.construction_demo.LT_501_findMode;


import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;


public class Solution {
    ArrayList<Integer> res;
    TreeNode pre;
    int count;
    int maxCount;

    public int[] findMode(TreeNode root) {
        res = new ArrayList<>();
        pre = null;
        count = 0;
        maxCount = 0;
        findMode2(root);
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public void findMode2(TreeNode root) {
        if (root == null) return;
        findMode2(root.left);//左
        //中
        // 计数
        if (pre == null || root.val != pre.val) {
            count = 1;
        } else {
            count++;
        }
        // 更新结果以及maxCount
        if (count > maxCount) {
            res.clear();
            res.add(root.val);
            maxCount = count;
        } else if (count == maxCount) {
            res.add(root.val);
        }
        pre = root;

        findMode2(root.right);//右
    }

    public static void main(String[] args) {
//        Integer[] arr = {0};
//        Integer[] arr = {1, null, 2, 2};
        Integer[] arr = {1, null, 2};
        BinaryTree bt = new BinaryTree(arr);

        Solution sl = new Solution();
        System.out.println(Arrays.toString(sl.findMode(bt.root)));
    }
}
