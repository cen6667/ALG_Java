package com_base.Tree_demo.demo.attribute_demo.LT_111_minDepth;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int min_depth = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int len = deque.size();
            min_depth++;
            while (len>0){
                TreeNode poll = deque.poll();
                if (poll.left != null) deque.offer(poll.left);
                if (poll.right != null) deque.offer(poll.right);
                len--;

                if(poll.left == null && poll.right == null) return min_depth;
            }

        }
        return min_depth;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,null,null,5};
        BinaryTree bt = new BinaryTree(arr);

        Solution2 sl = new Solution2();
        System.out.println(sl.minDepth(bt.root));
    }
}
