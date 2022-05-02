package com_base.dynamic_programming.rob_question.LT_337_rob3;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;
//成树
public class Solution {
    // 3.状态标记递归
    // 执行用时：0 ms , 在所有 Java 提交中击败了 100% 的用户
    // dp数组就是一个长度为2的数组
    // 下标为0记录不偷该节点所得到的的最大金钱，下标为1记录偷该节点所得到的的最大金钱。
    // 不偷：Max(左孩子不偷，左孩子偷) + Max(又孩子不偷，右孩子偷)
    // root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) +
    // Math.max(rob(root.right)[0], rob(root.right)[1])
    // 偷：左孩子不偷+ 右孩子不偷 + 当前节点偷
    // root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
    public int rob3(TreeNode root) {
        int[] res = robAction1(root);
        return Math.max(res[0], res[1]);
    }

    int[] robAction1(TreeNode root) {
        int res[] = new int[2];
        if (root == null)
            return res;
        // 后序遍历
        int[] left = robAction1(root.left);
        int[] right = robAction1(root.right);
        // 不偷本层
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷本层
        res[1] = root.val + left[0] + right[0];
        return res;
    }

    public static void main(String[] args) {
        Integer[] arr = {3,2,3,null,3,null,1};
        BinaryTree bt = new BinaryTree(arr);
        Solution sl = new Solution();
        System.out.println(sl.rob3(bt.root));
    }

}
