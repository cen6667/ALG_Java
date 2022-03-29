package com_base.Tree_demo.demo.modify_demo.LT_701_insertIntoBST;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

public class Solution {
//    public TreeNode insertIntoBST(TreeNode root, int val) {
//        TreeNode res = new TreeNode(val);
//        insert(root, res);
//        return root;
//    }
//
//    public void insert(TreeNode root, TreeNode res) {
//        if (root == null) return;
//        if (root.left == null && res.val < root.val) {
//            root.left = res;
//            return;
//        } else if (root.right == null && res.val > root.val) {
//            root.right = res;
//            return;
//        }
//
//
//        if (res.val > root.val) insert(root.right, res);
//        else if (res.val < root.val) insert(root.left, res);
//    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) // 如果当前节点为空，也就意味着val找到了合适的位置，此时创建节点直接返回。
            return new TreeNode(val);

        if (root.val < val){
            root.right = insertIntoBST(root.right, val); // 递归创建右子树
        }else if (root.val > val){
            root.left = insertIntoBST(root.left, val); // 递归创建左子树
        }
        return root;
    }

    public static void main(String[] args) {
//        int val = 4;
//        Integer[] arr = {5, null, 14, 10, 77, null, null, null, 95, null, null};
        int val = 5;
        Integer[] arr = {4,2,7,1,3};
        BinaryTree bt = new BinaryTree(arr);

        Solution sl = new Solution();
        BinaryTree.showBinaryTree(sl.insertIntoBST(bt.root, val));
    }
}
