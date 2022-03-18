package com_base.Tree_demo.demo.order_demo.LT_145_postorder;

import com_base.Tree_demo.TreeNode;

import java.util.*;

public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode r3 = new TreeNode(3);
        TreeNode r2 = new TreeNode(2, r3,null);
        TreeNode r1 = new TreeNode(1, null, r2);

        List<Integer> res = new ArrayList<>();
        Solution2 sl = new Solution2();
        res = sl.postorderTraversal(r1);
        System.out.println(res.toString());


    }
}