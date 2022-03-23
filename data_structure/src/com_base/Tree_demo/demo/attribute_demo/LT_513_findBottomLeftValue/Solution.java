package com_base.Tree_demo.demo.attribute_demo.LT_513_findBottomLeftValue;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        int res=0;

        Deque<TreeNode> deque = new LinkedList<>();
        if(root.left != null) deque.addLast(root.left);
        if(root.right!= null) deque.addLast(root.right);
        while(!deque.isEmpty()){
            res = deque.peekFirst().val;
            int len =deque.size();
            while(len-->0){
                TreeNode tmp = deque.pollFirst();
                if(tmp.left != null) deque.addLast(tmp.left);
                if(tmp.right!= null) deque.addLast(tmp.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,1,2,3};
        BinaryTree bt = new BinaryTree(arr);

        Solution sl = new Solution();
        System.out.println(sl.findBottomLeftValue(bt.root));
    }
}
