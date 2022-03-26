package com_base.Tree_demo.demo.construction_demo.LT_617_mergeTrees;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root1);
        deque.addFirst(root2);
        while (!deque.isEmpty()) {
            //注意前中后遍历是用栈记得改顺序
            TreeNode tmp2 = deque.pollFirst();
            TreeNode tmp1 = deque.pollFirst();

            tmp1.val += tmp2.val;

            if (tmp1.right != null && tmp2.right != null) {
                deque.addFirst(tmp1.right);
                deque.addFirst(tmp2.right);
            }
            if (tmp1.left != null && tmp2.left != null) {
                deque.addFirst(tmp1.left);
                deque.addFirst(tmp2.left);
            }
            if (tmp1.right == null && tmp2.right != null) {
                tmp1.right = tmp2.right;
            }
            if (tmp1.left == null && tmp2.left != null) {
                tmp1.left = tmp2.left;
            }
            //因为以tmp1为主，所以不需要判断tmp2左右节点为空的情况
        }
        return root1;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1, 3, 2, 5};
        BinaryTree bt1 = new BinaryTree(arr1);
        Integer[] arr2 = {2, 1, 3, null, 4, null, 7};
        BinaryTree bt2 = new BinaryTree(arr2);

        Solution2 sl = new Solution2();
        TreeNode root = sl.mergeTrees(bt1.root, bt2.root);
        String[] arrout = BinaryTree.showBinaryTreeByArray(root);
        System.out.println(Arrays.toString(arrout));
    }
}
