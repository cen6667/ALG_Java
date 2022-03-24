package com_base.Tree_demo.demo.attribute_demo.LT_113_pathSum;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        LinkedList<Integer> deque = new LinkedList<>();
        pathRes(root, targetSum, deque);
        return res;
    }

    public void pathRes(TreeNode root, int targetSum, LinkedList<Integer> deque) {
        if (root == null) return;
        deque.addLast(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                // 记得要new啊，要不然一直变
                res.add((List<Integer>) new LinkedList<>(deque));
            }
            return;
        }

        if(root.left != null) {
            pathRes(root.left, targetSum - root.val, deque);
            deque.pollLast();
        }
        if(root.right != null) {
            pathRes(root.right, targetSum - root.val, deque);
            deque.pollLast();
        }
    }


    public static void main(String[] args) {
//        Integer[] arr = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
//        int targetSum = 22;
        Integer[] arr = {1,2,3};
        int targetSum = 5;

        BinaryTree bt = new BinaryTree(arr);

        Solution sl = new Solution();
        System.out.println(sl.pathSum(bt.root, targetSum));
    }
}
