package com_base.Tree_demo.demo.order_demo.LT_94_inorder;

import com_base.Tree_demo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    

    public static void main(String[] args) {
        TreeNode r3 = new TreeNode(3);
        TreeNode r2 = new TreeNode(2, r3,null);
        TreeNode r1 = new TreeNode(1, null, r2);

        List<Integer> res = new ArrayList<>();
        Solution sl = new Solution();
        res = sl.inorderTraversal(r1);
        System.out.println(res.toString());


    }

}


