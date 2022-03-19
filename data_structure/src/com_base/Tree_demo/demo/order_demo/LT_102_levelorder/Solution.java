package com_base.Tree_demo.demo.order_demo.LT_102_levelorder;

import com_base.Tree_demo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        // checkFun01(root, 0);
        checkFun02(root);
        return resList;
    }

    //BFS--迭代方式--借助队列
    public void checkFun02(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            //size是上一次循环新加进来的一层节点数量，不包括下面加进队列的元素
            int len = que.size();

            while (len > 0) {
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);

                if (tmpNode.left != null) que.offer(tmpNode.left);
                if (tmpNode.right != null) que.offer(tmpNode.right);
                len--;
            }

            resList.add(itemList);
        }
    }

    //DFS--递归方式
    public void checkFun01(TreeNode node, Integer deep) {
        if (node == null) return;
        deep++;

        //每一层只需要建一个List，这一层只有第一个节点小于deep
        if (resList.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);

        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }


    public static void main (String[]args){
        TreeNode r4 = new TreeNode(14);
        TreeNode r3 = new TreeNode(13);
        TreeNode r2 = new TreeNode(12, r3, r4);
        TreeNode r1 = new TreeNode(11, null, r2);

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Solution sl = new Solution();
        res = sl.levelOrder(r1);
        System.out.println(res.toString());


    }
}


