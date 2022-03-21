package com_base.Tree_demo.demo.attribute_demo.LT_101_isSymmetric;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

//递归
public class Solution3 {
    /**
     * 迭代法
     * 使用双端队列，相当于两个栈
     */
    //没上一个队列好理解
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.pollFirst();
            TreeNode rightNode = deque.pollLast();
            if (leftNode == null && rightNode == null) {
                continue;
            }
//            if (leftNode == null && rightNode != null) {
//                return false;
//            }
//            if (leftNode != null && rightNode == null) {
//                return false;
//            }
//            if (leftNode.val != rightNode.val) {
//                return false;
//            }
            // 以上三个判断条件合并
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            deque.offerFirst(leftNode.left);
            deque.offerFirst(leftNode.right);
            deque.offerLast(rightNode.right);
            deque.offerLast(rightNode.left);
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,2,null,3,null,3};
        BinaryTree bt = new BinaryTree(arr);

        Solution3 sl = new Solution3();
        System.out.println(sl.isSymmetric(bt.root));
    }
}
