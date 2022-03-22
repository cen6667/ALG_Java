package com_base.Tree_demo.demo.attribute_demo.LT_104_maxDepth;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    /**
     * 迭代法，使用层序遍历
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int len = deque.size();
            depth++;
            while (len > 0) {
                //层序遍历最核心的一句
                TreeNode poll = deque.poll();
                if (poll.left != null) deque.offer(poll.left);
                if (poll.right != null) deque.offer(poll.right);
                len--;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 2, null, 3, null, 3};
        BinaryTree bt = new BinaryTree(arr);

        Solution2 sl = new Solution2();
        System.out.println(sl.maxDepth(bt.root));
    }
}
