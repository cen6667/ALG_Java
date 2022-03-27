package com_base.Tree_demo.demo.construction_demo.LT_530_getMinimumDifference;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

public class Solution {
    private int res = Integer.MAX_VALUE;
    TreeNode pre;

    public int getMinimumDifference(TreeNode root) {
        inorderDiff(root);
        return res;
    }

    public void inorderDiff(TreeNode root) {
        if (root == null) return;
        inorderDiff(root.left);
        if (pre != null) {
            res = Math.min(root.val - pre.val, res);
        }
        pre = root;
        inorderDiff(root.right);
    }


    public static void main(String[] args) {
//        Integer[] arr = {4, 2, 6, 1, 3};
        Integer[] arr = {1,0,48,null,null,12,49};
        BinaryTree bt = new BinaryTree(arr);
        Solution sl = new Solution();
        int res = sl.getMinimumDifference(bt.root);
        System.out.println(res);
    }
}
