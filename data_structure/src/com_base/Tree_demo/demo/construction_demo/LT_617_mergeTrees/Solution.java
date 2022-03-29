package com_base.Tree_demo.demo.construction_demo.LT_617_mergeTrees;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

import java.util.Arrays;

import static com_base.Tree_demo.BinaryTree.showBinaryTree;

//合成二叉树，两个二叉树相加
//使用递归前序遍历
public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null) return root2;
        if(root2==null) return root1;

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1,3,2,5};
        BinaryTree bt1 = new BinaryTree(arr1);
        Integer[] arr2 = {2,1,3,null,4,null,7};
        BinaryTree bt2 = new BinaryTree(arr2);

        Solution sl = new Solution();
        TreeNode root = sl.mergeTrees(bt1.root, bt2.root);
        showBinaryTree(root);
    }
}
