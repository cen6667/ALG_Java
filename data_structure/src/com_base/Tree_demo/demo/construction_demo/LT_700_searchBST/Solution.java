package com_base.Tree_demo.demo.construction_demo.LT_700_searchBST;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

import static com_base.Tree_demo.BinaryTree.showBinaryTree;

//合成二叉树，两个二叉树相加
//使用递归前序遍历
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        else if (root.val > val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }

    public static void main(String[] args) {
        Integer[] arr = {4, 2, 7, 1, 3};
        BinaryTree bt = new BinaryTree(arr);
        int val = 2;

        Solution sl = new Solution();
        TreeNode root = sl.searchBST(bt.root, val);
        showBinaryTree(root);
    }
}
