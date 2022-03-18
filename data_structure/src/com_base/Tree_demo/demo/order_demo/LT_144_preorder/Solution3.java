package com_base.Tree_demo.demo.order_demo.LT_144_preorder;

import com_base.Tree_demo.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution3 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node!= null){
                stack.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                if (node.right!=null) stack.push(node.right);  // 添加右节点（空节点不入栈）
                if (node.left!=null) stack.push(node.left);    // 添加左节点（空节点不入栈）
                stack.push(node);                          // 添加中节点
                stack.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。
            }else {
                stack.pop();           // 将空节点弹出
                node = stack.pop();    // 重新取出栈中元素
                res.add(node.val); // 加入到结果集
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode r3 = new TreeNode(3);
        TreeNode r2 = new TreeNode(2, r3,null);
        TreeNode r1 = new TreeNode(1, null, r2);

        List<Integer> res = new ArrayList<>();
        Solution3 sl = new Solution3();
        res = sl.preorderTraversal(r1);
        System.out.println(res.toString());
    }
}