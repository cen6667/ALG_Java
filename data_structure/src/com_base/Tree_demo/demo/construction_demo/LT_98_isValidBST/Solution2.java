package com_base.Tree_demo.demo.construction_demo.LT_98_isValidBST;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;// 左
            }
            // 中，处理
            TreeNode pop = stack.pop();
            if (pre != null && pop.val <= pre.val) {
                return false;
            }
            pre = pop;

            root = pop.right;// 右
        }
        return true;
    }



    public static void main(String[] args) {
        Integer[] arr = {2,2,2};
//        Integer[] arr = {-2147483648};
//        Integer[] arr = {2, 1, 3};
//        Integer[] arr = {5, 1, 4, null, null, 3, 6};
        BinaryTree bt = new BinaryTree(arr);

        Solution2 sl = new Solution2();
        System.out.println(sl.isValidBST(bt.root));
    }
}
