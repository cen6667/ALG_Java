package com_base.Tree_demo.demo.attribute_demo.LT_101_isSymmetric;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//队列
public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.poll();
            TreeNode rightNode = deque.poll() ;
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
            // 这里顺序与使用Deque不同
            deque.offer(leftNode.left);
            deque.offer(rightNode.right);
            deque.offer(leftNode.right);
            deque.offer(rightNode.left);
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,2,3,4,4,3};
        BinaryTree bt = new BinaryTree(arr);

        Solution2 sl = new Solution2();
        System.out.println(sl.isSymmetric(bt.root));
    }
}
