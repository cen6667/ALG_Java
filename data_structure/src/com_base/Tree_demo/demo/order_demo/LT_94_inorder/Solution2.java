package com_base.Tree_demo.demo.order_demo.LT_94_inorder;

import com_base.Tree_demo.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if(cur!= null){
                stack.push(cur);
                cur = cur.left; // 左
            }else {
                cur = stack.pop();// 左节点空，栈不空，则向上找父节点
                res.add(cur.val); // 输出中间结点
                cur = cur.right; //指向右节点
            }
        }
        return res;
    }
    

    public static void main(String[] args) {
        TreeNode r3 = new TreeNode(3);
        TreeNode r2 = new TreeNode(2, r3,null);
        TreeNode r1 = new TreeNode(1, null, r2);

        List<Integer> res = new ArrayList<>();
        Solution2 sl = new Solution2();
        res = sl.inorderTraversal(r1);
        System.out.println(res.toString());


    }

}


