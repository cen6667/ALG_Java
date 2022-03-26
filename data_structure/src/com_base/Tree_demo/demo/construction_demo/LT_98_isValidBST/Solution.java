package com_base.Tree_demo.demo.construction_demo.LT_98_isValidBST;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

public class Solution {
    long max = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean leftbl = isValidBST(root.left);
        if (max < root.val) max = root.val;
        else return false;
        boolean rightbl = isValidBST(root.right);
        return leftbl && rightbl;
    }

    //如果测试数据中有 longlong的最小值，怎么办？
    TreeNode prenode = null; // 用来记录前一个节点
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        boolean leftbl = isValidBST(root.left);
        if (prenode ==null || prenode.val < root.val) prenode = root;
        else return false;
        boolean rightbl = isValidBST(root.right);
        return leftbl && rightbl;
    }


    public static void main(String[] args) {
        Integer[] arr = {2,2,2};
//        Integer[] arr = {-2147483648};
//        Integer[] arr = {2, 1, 3};
//        Integer[] arr = {5, 1, 4, null, null, 3, 6};
        BinaryTree bt = new BinaryTree(arr);

        Solution sl = new Solution();
        System.out.println(sl.isValidBST2(bt.root));
    }
}
