package com_base.Tree_demo.demo.attribute_demo.LT_112_hasPathSum;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;


public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        if(root.left == null && root.right == null) return targetSum == root.val;

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

//        if(root == null) return false;
//
//        int dif = targetSum - root.val;
//
//        boolean leavesbl = (root.left == null && root.right == null);
//        if(dif == 0 && leavesbl) return true;
//
//        boolean leftbl = hasPathSum(root.left, dif);
//        boolean rightbl = hasPathSum(root.right, dif);
//
//
//        if(leftbl || rightbl) return true;
//
//        return false;
    }


    public static void main(String[] args) {
        Integer[] arr = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        int targetSum = 22;
//        Integer[] arr = {1,2};
//        int targetSum = 1;

        BinaryTree bt = new BinaryTree(arr);

        Solution sl = new Solution();
        System.out.println(sl.hasPathSum(bt.root, targetSum));
    }
}
