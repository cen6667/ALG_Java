package com_base.Tree_demo.demo.attribute_demo.LT_100_isSameTree;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 首先排除空节点的情况
        if (p == null && q == null) return true;
        if(p== null || q==null) return false;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(p);
        deque.addLast(q);
        while(!deque.isEmpty()){
            TreeNode pnode = deque.pollFirst();
            TreeNode qnode = deque.pollFirst();
            if(pnode == null && qnode==null) continue;

            if(pnode == null || qnode==null || pnode.val != qnode.val) return false;

            deque.addLast(pnode.left);
            deque.addLast(qnode.left);
            deque.addLast(pnode.right);
            deque.addLast(qnode.right);
        }
        return true;

    }

    public static void main(String[] args) {
        Integer[] arr_p = {1,2,3};
        Integer[] arr_q = {1,2,3};

        BinaryTree bt_p = new BinaryTree(arr_p);
        BinaryTree bt_q = new BinaryTree(arr_q);

        Solution sl = new Solution();
        System.out.println(sl.isSameTree(bt_p.root, bt_q.root));
    }
}
