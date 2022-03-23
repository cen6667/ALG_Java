package com_base.Tree_demo.demo.attribute_demo.LT_404_sumOfLeftLeaves;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root.left == null && root.right == null) return 0;
        int leftsum = 0;
        int rightsum = 0;

        if(root.left!=null) leftsum = sumLeft(root.left, true);
        if(root.right!=null) rightsum = sumLeft(root.right, false);
        return leftsum + rightsum;
    }

    public int sumLeft(TreeNode root, boolean leftFlag){
        if (root.left == null && root.right == null && leftFlag){
            return root.val;
        }
        int leftsum = 0;
        int rightsum = 0;

        if(root.left!=null) leftsum = sumLeft(root.left, true);
        if(root.right!=null) rightsum = sumLeft(root.right, false);
        return leftsum + rightsum;
    }

    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        BinaryTree bt = new BinaryTree(arr);

        Solution sl = new Solution();
        System.out.println(sl.sumOfLeftLeaves(bt.root));
    }
}
