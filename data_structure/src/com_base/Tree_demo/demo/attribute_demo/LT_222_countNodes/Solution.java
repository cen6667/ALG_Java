package com_base.Tree_demo.demo.attribute_demo.LT_222_countNodes;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftdepth = 0;
        TreeNode tmp = root.left;
        while (tmp != null) {
            tmp = tmp.left;
            leftdepth++;
        }

        int rightdepth = 0;
        tmp = root.right;
        while (tmp != null) {
            tmp = tmp.right;
            rightdepth++;
        }

        if (leftdepth == rightdepth) {
            return (2 << leftdepth) - 1;
        }

        int leftcount = countNodes(root.left);
        int rightcount = countNodes(root.right);

        return leftcount + rightcount + 1;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        BinaryTree bt = new BinaryTree(arr);

        Solution sl = new Solution();
        System.out.println(sl.countNodes(bt.root));
    }
}
