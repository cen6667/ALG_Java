package com_base.Tree_demo.demo.construction_demo.LT_700_searchBST;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;


import static com_base.Tree_demo.BinaryTree.showBinaryTree;

//合成二叉树，两个二叉树相加
//使用递归前序遍历
public class Solution2 {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode tmp = root;
        do{
            if (tmp.val == val) return tmp;
            else if(tmp.val > val) tmp = tmp.left;
            else tmp = tmp.right;
        }while (true);
    }

    public static void main(String[] args) {
        Integer[] arr = {62,2,93,null,30,null,null,15,null,null,null};
        BinaryTree bt = new BinaryTree(arr);
        int val = 15;

        Solution2 sl = new Solution2();
        TreeNode root = sl.searchBST(bt.root, val);
        showBinaryTree(root);
    }
}
