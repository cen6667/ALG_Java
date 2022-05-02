package com_base.dynamic_programming.rob_question.LT_337_rob3;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

//成树
public class Solution2 {
    // 1.递归去偷，超时
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        int money = root.val;
        if (root.left != null) {
            money += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(money, rob(root.left) + rob(root.right));
    }

    public static void main(String[] args) {
        Integer[] arr = {3,2,3,null,3,null,1};
        BinaryTree bt = new BinaryTree(arr);
        Solution2 sl = new Solution2();
        System.out.println(sl.rob(bt.root));
    }

}
