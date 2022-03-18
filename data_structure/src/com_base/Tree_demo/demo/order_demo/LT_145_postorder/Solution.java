package com_base.Tree_demo.demo.order_demo.LT_145_postorder;

import com_base.Tree_demo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    void postorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);

    }

    public static void main(String[] args) {
        TreeNode r3 = new TreeNode(3);
        TreeNode r2 = new TreeNode(2, r3,null);
        TreeNode r1 = new TreeNode(1, null, r2);

        List<Integer> res = new ArrayList<>();
        Solution sl = new Solution();
        res = sl.postorderTraversal(r1);
        System.out.println(res.toString());


    }
}