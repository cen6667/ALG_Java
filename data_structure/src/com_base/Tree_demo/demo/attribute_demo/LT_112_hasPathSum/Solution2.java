package com_base.Tree_demo.demo.attribute_demo.LT_112_hasPathSum;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;


public class Solution2 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        Deque<TreeNode> deque = new LinkedList<>();
        Deque<Integer> tar = new LinkedList<>();
        deque.addFirst(root);
        tar.addFirst(targetSum);
        while (!deque.isEmpty() && !tar.isEmpty()){
            TreeNode tmp = deque.pollFirst();
            int tartmp = tar.pollFirst();
            if(tmp.left == null && tmp.right == null){
                if(tmp.val==tartmp) return true;
                else continue;
            }

            if (tmp.right != null){
                deque.addFirst(tmp.right);
                tar.addFirst(tartmp - tmp.val);
            }
            if (tmp.left != null){
                deque.addFirst(tmp.left);
                tar.addFirst(tartmp - tmp.val);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Integer[] arr = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        int targetSum = 22;
//        Integer[] arr = {1,2};
//        int targetSum = 1;
//        Integer[] arr = {1,-2,-3,1,3,-2,null,-1};
//        int targetSum = 3;

        BinaryTree bt = new BinaryTree(arr);

        Solution2 sl = new Solution2();
        System.out.println(sl.hasPathSum(bt.root, targetSum));
    }
}
