package com_base.Tree_demo.demo.attribute_demo.LT_113_pathSum;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> deque = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        pathRes(root, targetSum);
        return res;
    }

    public void pathRes(TreeNode root, int targetSum) {
        if (root == null) return;
        deque.addLast(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            // 记得要new啊，要不然一直变
            res.add((List<Integer>) new LinkedList<>(deque));
        }

        pathRes(root.left, targetSum - root.val);
        pathRes(root.right, targetSum - root.val);
        //回溯每个点都要回溯，不要跳过回溯否则平添麻烦
        deque.pollLast();
    }


    public static void main(String[] args) {
        Integer[] arr = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        int targetSum = 22;
//        Integer[] arr = {1,2,3};
//        int targetSum = 5;

        BinaryTree bt = new BinaryTree(arr);

        Solution2 sl = new Solution2();
        System.out.println(sl.pathSum(bt.root, targetSum));
    }
}
