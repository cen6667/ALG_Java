package com_base.Tree_demo.demo.attribute_demo.LT_104_maxDepth;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        return getdepth(root);
    }

    public int getdepth(TreeNode root) {
        if (root == null) return 0;
        int ld = getdepth(root.left);
        int rd = getdepth(root.right);

        return Math.max(ld, rd) + 1;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 2, null, 3, null, 3};
        BinaryTree bt = new BinaryTree(arr);

        Solution sl = new Solution();
        System.out.println(sl.maxDepth(bt.root));
    }
}
