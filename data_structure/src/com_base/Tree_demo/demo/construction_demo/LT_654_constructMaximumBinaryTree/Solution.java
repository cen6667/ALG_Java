package com_base.Tree_demo.demo.construction_demo.LT_654_constructMaximumBinaryTree;

import com_base.Tree_demo.TreeNode;

import java.util.Arrays;

import static com_base.Tree_demo.BinaryTree.showBinaryTreeByArray;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree1(nums, 0, nums.length);
    }

    public TreeNode constructMaximumBinaryTree1(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) {// 没有元素了
            return null;
        }
        if (rightIndex - leftIndex == 1) {// 只有一个元素
            return new TreeNode(nums[leftIndex]);
        }
        // 最大值所在位置
        int maxIndex = leftIndex;
        int maxVal = nums[maxIndex];
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxVal){
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        // 根据maxIndex划分左右子树
        root.left = constructMaximumBinaryTree1(nums, leftIndex, maxIndex);
        root.right = constructMaximumBinaryTree1(nums, maxIndex + 1, rightIndex);
        return root;

    }
    public static void main(String[] args) {
        int[] arr = {3,2,1,6,0,5};
        Solution sl = new Solution();
        TreeNode root = sl.constructMaximumBinaryTree(arr);
        String[] arrout = showBinaryTreeByArray(root);
        System.out.println(Arrays.toString(arrout));
    }
}
