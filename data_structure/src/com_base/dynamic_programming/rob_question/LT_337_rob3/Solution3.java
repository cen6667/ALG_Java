package com_base.dynamic_programming.rob_question.LT_337_rob3;

import com_base.Tree_demo.BinaryTree;
import com_base.Tree_demo.TreeNode;

import java.util.HashMap;
import java.util.Map;

//成树
public class Solution3 {
    // 2.递归去偷，记录状态
    // 执行用时：3 ms , 在所有 Java 提交中击败了 56.24% 的用户
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> memo = new HashMap<>();
        return robAction(root, memo);
    }

    int robAction(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null)
            return 0;
        if (memo.containsKey(root))
            return memo.get(root);
        int money = root.val;
        if (root.left != null) {
            money += robAction(root.left.left, memo) + robAction(root.left.right, memo);
        }
        if (root.right != null) {
            money += robAction(root.right.left, memo) + robAction(root.right.right, memo);
        }
        int res = Math.max(money, robAction(root.left, memo) + robAction(root.right, memo));
        memo.put(root, res);
        return res;
    }


    public static void main(String[] args) {
        Integer[] arr = {3,2,3,null,3,null,1};
        BinaryTree bt = new BinaryTree(arr);
        Solution3 sl = new Solution3();
        System.out.println(sl.rob(bt.root));
    }

}
