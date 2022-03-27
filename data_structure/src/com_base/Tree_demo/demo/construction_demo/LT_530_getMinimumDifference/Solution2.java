package com_base.Tree_demo.demo.construction_demo.LT_530_getMinimumDifference;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {

    public int getMinimumDifference(TreeNode root) {
        int res = Integer.MAX_VALUE;
        TreeNode pre = null;
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode cur = root;
        while (cur!=null || !deque.isEmpty()) {
            if(cur != null){
                deque.addFirst(cur);
                cur = cur.left;
            }else {
                cur = deque.pollFirst();
                if(pre != null) res = Math.min((cur.val - pre.val), res);
                pre = cur;
                cur = cur.right;
            }
        }
        return res;
    }


    public static void main(String[] args) {
//        Integer[] arr = {4, 2, 6, 1, 3};
        Integer[] arr = {1, 0, 48, null, null, 12, 49};
        BinaryTree bt = new BinaryTree(arr);
        Solution2 sl = new Solution2();
        int res = sl.getMinimumDifference(bt.root);
        System.out.println(res);
    }
}
