package com_base.Tree_demo.demo.order_demo.LT_144_preorder;

import com_base.Tree_demo.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode r3 = new TreeNode(3);
        TreeNode r2 = new TreeNode(2, r3,null);
        TreeNode r1 = new TreeNode(1, null, r2);

        List<Integer> res = new ArrayList<>();
        Solution2 sl = new Solution2();
        res = sl.preorderTraversal(r1);
        System.out.println(res.toString());
    }
}