package com_base.Tree_demo.demo.attribute_demo.LT_111_minDepth;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left == null) {
            return rightDepth + 1;
        }
        if (root.right == null) {
            return leftDepth + 1;
        }
        // 左右结点都不为null
        return Math.min(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 2, null, 3};
        BinaryTree bt = new BinaryTree(arr);

        Solution sl = new Solution();
        System.out.println(sl.minDepth(bt.root));
    }
}
