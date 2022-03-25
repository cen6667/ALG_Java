package com_base.Tree_demo.demo.construction_demo.LT_106_buildTree;

import com_base.Tree_demo.TreeNode;

import java.util.Arrays;

import static com_base.Tree_demo.BinaryTree.showBinaryTreeByArray;

// 从前序与中序遍历序列构造二叉树
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree1(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
    public TreeNode buildTree1(int[] inorder, int inLeft, int inRight,
                               int[] postorder, int postLeft, int postRight) {
        // 第一步：如果数组大小为零的话，说明是空节点了。
        if (inRight - inLeft < 1) {
            return null;
        }
        // 只有一个元素了
        if (inRight - inLeft == 1) {
            return new TreeNode(inorder[inLeft]);
        }

        // 第二步：如果不为空，那么取后序数组最后一个元素作为节点元素。
        int rootVal = postorder[postRight - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;

        // 第三步：找到后序数组最后一个元素在中序数组的位置，作为切割点
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        //根据rootIndex划分左右子树
        root.left = buildTree1(inorder, inLeft, rootIndex,
                postorder, postLeft, postLeft + (rootIndex - inLeft));
        root.right = buildTree1(inorder, rootIndex + 1, inRight,
                postorder, postLeft + (rootIndex - inLeft), postRight - 1);
        return root;

    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        Solution sl = new Solution();
        TreeNode root = sl.buildTree(inorder, postorder);
        String[] arrout = showBinaryTreeByArray(root);
        System.out.println(Arrays.toString(arrout));
    }
}
